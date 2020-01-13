package com.bei.mybatis.plus.mybatisplus.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author bei
 * @2020/1/13 14:29
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.bei.mybatis.plus.mybatisplus.mapper")
public class MyBatisPlusConfig {

}
