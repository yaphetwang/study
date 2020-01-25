package com.example.study.controller;

import com.example.study.entity.User;
import com.example.study.manage.UserManage;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

/**
 * @author wyf
 * @date 2019/7/20 21:50
 * @description
 * 测试事务的生效
 */
@RestController
@RequestMapping("/tx")
public class TxTestController {

    @Resource
    private UserManage userManage;

    @PostMapping("/insert")
    public int getUser(@NotNull @RequestBody User user) {
        return userManage.insertUser(user);
    }

}