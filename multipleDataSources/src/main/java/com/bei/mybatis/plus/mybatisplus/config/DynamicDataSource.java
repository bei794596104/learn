package com.bei.mybatis.plus.mybatisplus.config;

import com.bei.mybatis.plus.mybatisplus.support.DynamicDataSourceContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author lengleng
 * @date 2019-03-31
 * <p>
 * 动态数据源类
 */
@Slf4j
public class DynamicDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		return DynamicDataSourceContextHolder.getDataSourceType();
	}
}
