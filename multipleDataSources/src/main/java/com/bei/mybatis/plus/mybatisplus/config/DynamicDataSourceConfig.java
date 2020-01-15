package com.bei.mybatis.plus.mybatisplus.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.bei.mybatis.plus.mybatisplus.aspectj.DataSourceAspect;
import com.bei.mybatis.plus.mybatisplus.support.DataSourceConstants;
import com.mysql.cj.jdbc.Driver;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author lengleng
 * @date 2019-03-31
 * <p>
 * 动态数据源切换配置
 */
@Slf4j
@Configuration
@AllArgsConstructor
public class DynamicDataSourceConfig {
	private final Map<Object, Object> dataSourceMap = new HashMap<>(8);
	private final DruidDataSourceProperties dataSourceProperties;

	@Bean
	public DataSourceAspect dataSourceAspect() {
		return new DataSourceAspect();
	}

	@Bean("dynamicDataSource")
	public DynamicDataSource dataSource() {
		DynamicDataSource ds = new DynamicDataSource();
		DruidDataSource cads = new DruidDataSource();
		cads.setUrl(dataSourceProperties.getUrl());
		cads.setDriverClassName(dataSourceProperties.getDriverClassName());
		cads.setUsername(dataSourceProperties.getUsername());
		cads.setPassword(dataSourceProperties.getPassword());
		ds.setDefaultTargetDataSource(cads);
		dataSourceMap.put(0, cads);
		ds.setTargetDataSources(dataSourceMap);
		return ds;
	}

	/**
	 * 组装默认配置的数据源，查询数据库配置
	 */
	@PostConstruct
	public void init() {
		DriverManagerDataSource dds = new DriverManagerDataSource();
		dds.setUrl(dataSourceProperties.getUrl());
		dds.setDriverClassName(dataSourceProperties.getDriverClassName());
		dds.setUsername(dataSourceProperties.getUsername());
		dds.setPassword(dataSourceProperties.getPassword());

		List<Map<String, Object>> dbList = new JdbcTemplate(dds).queryForList(DataSourceConstants.QUERY_DS_SQL);
		log.info("开始 -> 初始化动态数据源");
		Optional.of(dbList).ifPresent(list -> list.forEach(db -> {
			log.info("数据源:{}", db.get(DataSourceConstants.DS_NAME));
			DruidDataSource ds = new DruidDataSource();
			ds.setUrl(String.valueOf(db.get(DataSourceConstants.DS_JDBC_URL)));
			ds.setDriverClassName(Driver.class.getName());
			ds.setUsername((String) db.get(DataSourceConstants.DS_USER_NAME));
			ds.setPassword((String)db.get(DataSourceConstants.DS_USER_PWD));
			dataSourceMap.put(db.get(DataSourceConstants.DS_ROUTE_KEY), ds);
		}));

		log.info("完毕 -> 初始化动态数据源,共计 {} 条", dataSourceMap.size());
	}


}
