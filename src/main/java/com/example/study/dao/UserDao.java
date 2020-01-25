package com.example.study.dao;

import com.example.study.entity.User;
import org.springframework.stereotype.Component;

/**
 * @author wb-wyf372433
 * @date 2019/7/3 16:15
 * @description
 */
public interface UserDao {
    User getUserByName(String name);

    int insertUser(User user);
}