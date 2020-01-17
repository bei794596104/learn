package com.bei.mybatis.plus.mybatisplus.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bei.mybatis.plus.mybatisplus.component.BeiSender;
import com.bei.mybatis.plus.mybatisplus.service.UserService;
import com.bei.mybatis.plus.mybatisplus.utils.R;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bei
 * @2020/1/13 14:53
 */
@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    private BeiSender beiSender;

    @GetMapping("/page")
    public R getUserList(){
        return R.ok(userService.list());
    }

    @GetMapping("/send")
    public R send(){
        beiSender.sendMessage("1", 1L);
        return R.ok();
    }
}

