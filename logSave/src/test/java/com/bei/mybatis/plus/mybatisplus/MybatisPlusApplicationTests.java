package com.bei.mybatis.plus.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bei.mybatis.plus.mybatisplus.entity.User;
import com.bei.mybatis.plus.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisPlusApplicationTests {

    @Autowired
    private UserMapper userMapper;

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
