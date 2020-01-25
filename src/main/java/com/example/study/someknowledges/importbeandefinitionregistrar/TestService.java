package com.example.study.someknowledges.importbeandefinitionregistrar;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wb-wyf372433
 * @date 2019/7/4 11:41
 * @description
 */
@Service
public class TestService {

//    @Resource
//    UserRepo userRepo;

    public String get() {
//        userRepo.get();
        return "success";
    }
}
