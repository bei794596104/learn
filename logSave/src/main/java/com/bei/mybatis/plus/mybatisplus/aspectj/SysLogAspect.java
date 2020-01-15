/*
 *
 *      Copyright (c) 2018-2025, lengleng All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 *  this list of conditions and the following disclaimer.
 *  Redistributions in binary form must reproduce the above copyright
 *  notice, this list of conditions and the following disclaimer in the
 *  documentation and/or other materials provided with the distribution.
 *  Neither the name of the pig4cloud.com developer nor the names of its
 *  contributors may be used to endorse or promote products derived from
 *  this software without specific prior written permission.
 *  Author: lengleng (345912664@qq.com)
 *
 */

package com.bei.mybatis.plus.mybatisplus.aspectj;

import com.bei.mybatis.plus.mybatisplus.annotation.SysLog;
import com.bei.mybatis.plus.mybatisplus.constants.CommonConstants;
import com.bei.mybatis.plus.mybatisplus.event.SysLogEvent;
import com.bei.mybatis.plus.mybatisplus.utils.SysLogUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * 操作日志使用spring event异步入库
 *
 * @author bei
 */
@Slf4j
@Aspect
@AllArgsConstructor
@Component
public class SysLogAspect {
	private final ApplicationEventPublisher publisher;

	@Around("@annotation(sysLog)")
	public Object around(ProceedingJoinPoint point, SysLog sysLog) {
		String strClassName = point.getTarget().getClass().getName();
		String strMethodName = point.getSignature().getName();
		log.debug("[类名]:{},[方法]:{}", strClassName, strMethodName);

		com.bei.mybatis.plus.mybatisplus.entity.SysLog logVo = SysLogUtils.getSysLog();
		logVo.setTitle(sysLog.value());
		// 发送异步日志事件
		Long startTime = System.currentTimeMillis();
		Object obj = null;
		try
		{
			obj = point.proceed();
		}catch (Throwable e){
			logVo.setType(String.valueOf(CommonConstants.FAIL));
			log.error("异常信息:{}", e.getMessage());
			logVo.setException(e.getMessage());
			e.printStackTrace();
		}finally {
			Long endTime = System.currentTimeMillis();
			logVo.setTime(endTime - startTime);
			publisher.publishEvent(new SysLogEvent(logVo));
		}
		return obj;
	}
}
