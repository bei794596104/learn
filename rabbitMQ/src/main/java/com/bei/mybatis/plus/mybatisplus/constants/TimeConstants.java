package com.bei.mybatis.plus.mybatisplus.constants;

/**
 * @author bei
 * @2019/11/18 22:59
 */
public interface TimeConstants {
	/**
	 * 延时任务默认延时时间 15分钟
	 */
	Long DEFAULT_DELAYED_TIME = 15 * 60 * 1000L;

	/**
	 * 自动收货时间为7天
	 */
	Long AUTO_RECEIVE_TIME = 60 * 1000 * 60 * 24 * 7L;
//	Long AUTO_RECEIVE_TIME =  1 * 60 * 1000L;
}
