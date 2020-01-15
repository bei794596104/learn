package com.bei.mybatis.plus.mybatisplus.annotation;

import com.bei.mybatis.plus.mybatisplus.emun.DataSourceEnums;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/*
 * @Date : 2019/10/18 1:06
 * @auhtor : bei
 * @description : 切换数据源注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface DataSource {

    DataSourceEnums value() default DataSourceEnums.BUS_DATASOURCE_ID;
}
