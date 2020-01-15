package com.bei.mybatis.plus.mybatisplus.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author bei
 * @2020/1/13 14:29
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.bei.mybatis.plus.mybatisplus.mapper")
@ComponentScan("com.bei.mybatis.plus.mybatisplus")
public class MyBatisPlusConfig {

}
