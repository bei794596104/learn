package com.bei.mybatis.plus.mybatisplus.component;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author bei
 * @2020/1/17 15:09
 * 消费者
 */
@Component
public class KafkaConsumer {
    @KafkaListener(topics = "bei")
    public void listen(ConsumerRecord<?, ?> record){
        System.out.println(record.topic());
        System.out.println(record.offset());
        System.out.println(record.value());
    }
}
