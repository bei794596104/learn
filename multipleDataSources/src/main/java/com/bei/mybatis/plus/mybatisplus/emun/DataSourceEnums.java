package com.bei.mybatis.plus.mybatisplus.emun;

import com.bei.mybatis.plus.mybatisplus.constants.DataSourceConstant;

/*
 * @Date : 2019/10/18 11:29
 * @auhtor : bei
 * @description : 数据源常量
 */
public enum DataSourceEnums {
    // 商家数据源
    BUS_DATASOURCE_ID(DataSourceConstant.BUS_DATASOURCE_ID),

    // 平台方数据源id
    PLA_DATASOURCE_ID(DataSourceConstant.PLA_DATASOURCE_ID);

	// 数据源存放在数据库的id
    private int value;
	DataSourceEnums(int value){
		this.value = value;
	}
	public int getValue(){
		return this.value;
	}
}
