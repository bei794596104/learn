package com.bei.mybatis.plus.mybatisplus.controller;


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

    @GetMapping("/page")
    public R getUserList(){
        return R.ok(userService.newList1());
    }


    @GetMapping("/page2")
    public R getUserList2(){
        return R.ok(userService.newList2());
    }
}

