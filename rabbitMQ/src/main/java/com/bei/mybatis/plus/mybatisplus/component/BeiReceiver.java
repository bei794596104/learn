package com.bei.mybatis.plus.mybatisplus.component;

import com.rabbitmq.client.Channel;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 延时订单消费者
 * bei
 */
@Component
@Slf4j
public class BeiReceiver {

    /**
     * 订单需要先确认是否还是未付款状态
     */
	@RabbitListener(queues = "com.bei.task") // 设置队列路由键，和监听容器
	public void handle(String user, Message message, Channel channel){
//			System.out.println(message.getMessageProperties().getMessageId());
//			System.out.println(1/0);
			System.out.println("=====收到了");
			// TODO 通知 MQ 消息已被成功消费,可以ACK了

    }


}
