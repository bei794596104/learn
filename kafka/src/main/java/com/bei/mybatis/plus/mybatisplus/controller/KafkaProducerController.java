package com.bei.mybatis.plus.mybatisplus.controller;

import com.bei.mybatis.plus.mybatisplus.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bei
 * @2020/1/17 15:06
 * 生成者
 */
@RestController
@RequestMapping("/kafka")
public class KafkaProducerController {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @RequestMapping("/send")
    public R testSend(){
        kafkaTemplate.send("bei", "bei");
        return R.ok();
    }
}
