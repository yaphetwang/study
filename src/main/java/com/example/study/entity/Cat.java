package com.example.study.entity;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author wb-wyf372433
 * @date 2019/7/7 15:19
 * @description
 */
public class Cat implements InitializingBean, DisposableBean {
    public Cat(){
        System.out.println("cat constructor...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("cat afterPropertiesSet....");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("cat destroy.....");
    }
}
