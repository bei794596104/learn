package com.bei.mybatis.plus.mybatisplus.config;

import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


/**
 * @author Lucky
 * @date 2019-05-18
 * <p>
 * 自动配置类
 */
@AllArgsConstructor
@EnableConfigurationProperties({DruidDataSourceProperties.class})
public class DataSourceAutoConfiguration {

}
