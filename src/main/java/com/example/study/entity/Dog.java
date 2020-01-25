package com.example.study.entity;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author wb-wyf372433
 * @date 2019/7/7 14:50
 * @description
 */
public class Dog {
    public Dog(){
        System.out.println("dog constructor...");
    }

    //对象创建并赋值之后
    @PostConstruct
    public void postConstruct(){
        System.out.println("dog @PostConstruct .....");
    }

    //对象销毁之前
    @PreDestroy
    public void preDestroy(){
        System.out.println("dog @PreDestroy...");
    }
}
