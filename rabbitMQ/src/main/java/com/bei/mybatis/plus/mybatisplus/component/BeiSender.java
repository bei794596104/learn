package com.bei.mybatis.plus.mybatisplus.component;

import com.bei.mybatis.plus.mybatisplus.emun.QueueEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 订单延迟生产者
 * bei
 */
@Component
public class BeiSender {
    private static Logger logger = LoggerFactory.getLogger(BeiSender.class);
    @Autowired
    private RabbitTemplate rabbitTemplate;
    public void sendMessage(String userId, long delayTimes){
            rabbitTemplate.convertAndSend(QueueEnum.QUEUE_BEI_DEALY.getExchange(),
                    QueueEnum.QUEUE_BEI_DEALY.getRouteKey(), userId,
                    message -> {
                            message.getMessageProperties().setExpiration(String.valueOf(delayTimes));
                            // 当数据还没有持久化的时候，如果服务器宕机，设置此参数也可以恢复数据
                            message.getMessageProperties().setDeliveryMode(MessageProperties.DEFAULT_DELIVERY_MODE);
                            return message;
                        }
                    );
            logger.info("订单生成者 用户id：{}",userId);
    }
}
