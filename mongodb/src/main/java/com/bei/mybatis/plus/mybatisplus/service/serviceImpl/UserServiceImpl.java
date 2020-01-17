/*
 *    Copyright (c) 2018-2025, lengleng All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * Neither the name of the pig4cloud.com developer nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * Author: lengleng (345912664@qq.com)
 */

package com.bei.mybatis.plus.mybatisplus.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bei.mybatis.plus.mybatisplus.entity.User;
import com.bei.mybatis.plus.mybatisplus.mapper.UserMapper;
import com.bei.mybatis.plus.mybatisplus.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 用户
 *
 * @author bei
 * @date 2019-09-24 16:46:28
 */
@Service
@AllArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
