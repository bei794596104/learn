package com.bei.mybatis.plus.mybatisplus.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bei.mybatis.plus.mybatisplus.entity.User;
import com.bei.mybatis.plus.mybatisplus.service.UserService;
import com.bei.mybatis.plus.mybatisplus.utils.R;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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

    private final MongoTemplate mongoTemplate;

    @GetMapping("/page")
    public R getUserList(){
        return R.ok(userService.list());
    }

    @GetMapping("/save")
    public R save(){
        return R.ok(mongoTemplate.save(userService.list().get(1)));
    }

    @GetMapping("/get")
    public R get(){
        return R.ok(mongoTemplate.findAll(User.class));
    }

    /***
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("/getById")
    public User getBookById(int id) {
        Query query = new Query(Criteria.where("id").is(id));
        System.out.println(mongoTemplate.findOne(query, User.class));
        return mongoTemplate.findOne(query, User.class);
    }

    /***
     * update
     * @return
     */
    @GetMapping("/update")
    public R update() {
        System.out.println(mongoTemplate.upsert(new Query(Criteria.where("id").is(1)), new Update().set("age", 100), User.class));
        return R.ok();
    }
}

