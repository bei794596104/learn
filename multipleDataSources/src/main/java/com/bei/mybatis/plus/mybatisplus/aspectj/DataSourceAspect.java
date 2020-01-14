package com.bei.mybatis.plus.mybatisplus.aspectj;

import cn.hutool.core.util.ObjectUtil;
import com.bei.mybatis.plus.mybatisplus.annotation.DataSource;
import com.bei.mybatis.plus.mybatisplus.support.DynamicDataSourceContextHolder;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 *@author bei
 *@2020/1/14 11:43
 *
 */
@Aspect
@AllArgsConstructor
public class DataSourceAspect {

    @SneakyThrows
    @Around("@annotation(dataSource)")
    public Object around(ProceedingJoinPoint point, DataSource dataSource)
    {
        if (ObjectUtil.isNotNull(dataSource.value()))
        {
            DynamicDataSourceContextHolder.setDataSourceType(dataSource.value().getValue());
        }
        try
        {
            return point.proceed();
        }
        finally
        {
            // 销毁数据源 在执行方法之后
            DynamicDataSourceContextHolder.clearDataSourceType();
        }
    }
}
