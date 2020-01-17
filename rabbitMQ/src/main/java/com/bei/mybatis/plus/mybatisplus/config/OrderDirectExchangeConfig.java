package com.bei.mybatis.plus.mybatisplus.config;

import com.bei.mybatis.plus.mybatisplus.emun.QueueEnum;
import lombok.AllArgsConstructor;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * rabbitMQ采用路由模式
 * 一个交换机对应多个队列
 * bei
 */
@AllArgsConstructor
@Configuration
public class OrderDirectExchangeConfig {

    /**
     * 订单实际消费队列
     */
    @Bean
    public Queue orderQueue(){
        return new Queue(QueueEnum.QUEUE_BEI_task.getName());
    }

    /**
     * 订单延迟队列（死信队列）
     */
    @Bean
    public Queue orderTtlQueue(){
        return QueueBuilder
                .durable(QueueEnum.QUEUE_BEI_DEALY.getName())
                .withArgument("x-dead-letter-exchange", QueueEnum.QUEUE_BEI_DEALY.getExchange()) //到期后转发的交换机
                .withArgument("x-dead-letter-routing-key", QueueEnum.QUEUE_BEI_task.getRouteKey()) // 到期后转发的路由键
                .build();
    }

	/**
	 * 订单队列绑定到交换机上
	 */
	@Bean
	Binding orderBinding(DirectExchange orderExchange, Queue orderQueue){
		return BindingBuilder
				.bind(orderQueue)
				.to(orderExchange)
				.with(QueueEnum.QUEUE_BEI_task.getRouteKey());
	}

	/**
	 * 订单延迟队列 绑定到交换机
	 */
	@Bean
	Binding orderTtlBinding(DirectExchange orderExchange, Queue orderTtlQueue){
		return BindingBuilder
				.bind(orderTtlQueue)
				.to(orderExchange)
				.with(QueueEnum.QUEUE_BEI_DEALY.getRouteKey());
	}


    /**
     * 订单消息实际消费绑定的交换机
     */
    @Bean
    DirectExchange orderExchange(){
        return (DirectExchange) ExchangeBuilder.directExchange(QueueEnum.QUEUE_BEI_task.getExchange())
                // 开启持久化，如果服务器宕机消息依旧存在
                .durable(true)
                .build();
    }


}
