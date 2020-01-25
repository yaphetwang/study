package com.example.study.service;

import com.example.study.dao.UserDao;
import com.example.study.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wb-wyf372433
 * @date 2019/7/3 16:17
 * @description
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public User getUserByName(String name) {
        return userDao.getUserByName(name);
    }

    @Override
    public int insertUser(User user) {
        int result = userDao.insertUser(user);
        int a = 1 / 0;
        return result;
    }
}