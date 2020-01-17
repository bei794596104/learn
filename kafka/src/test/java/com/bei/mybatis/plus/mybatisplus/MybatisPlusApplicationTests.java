package com.bei.mybatis.plus.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bei.mybatis.plus.mybatisplus.entity.User;
import com.bei.mybatis.plus.mybatisplus.mapper.UserMapper;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.Arrays;

@SpringBootTest
class MybatisPlusApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Autowired // adminClien需要自己生成配置bean
    private AdminClient adminClient;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Test//自定义手动创建topic和分区
    public void testCreateTopic() throws InterruptedException {
        // 这种是手动创建 //10个分区，一个副本
        // 分区多的好处是能快速的处理并发量，但是也要根据机器的配置
        NewTopic topic = new NewTopic("bei", 10, (short) 1);
        adminClient.createTopics(Arrays.asList(topic));
        Thread.sleep(1000);
    }

    @Test
    void select() {
        System.out.println(userMapper.selectList(new QueryWrapper<User>()));
    }

    @Test
    void insert(){
        User user = new User();
        user.setAge(5);
        user.setEmail("5");
        user.setName("5");
        userMapper.insert(user);
    }

}
