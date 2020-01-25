package com.example.study.service;

import com.example.study.entity.User;

/**
 * @author wb-wyf372433
 * @date 2019/7/3 16:16
 * @description
 */
public interface UserService {
    User getUserByName(String name);

    int insertUser(User user);

}
