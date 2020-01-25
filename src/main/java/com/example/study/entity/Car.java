package com.example.study.entity;

/**
 * @author wb-wyf372433
 * @date 2019/7/7 14:50
 * @description
 */
public class Car {
    public Car(){
        System.out.println("car constructor...");
    }

    public void init(){
        System.out.println("car init .....");
    }

    public void destroy(){
        System.out.println("car destroy...");
    }
}
