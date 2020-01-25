package com.example.study;

import com.example.study.config.MainConfigOfBeanLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wb-wyf372433
 * @date 2019/7/7 15:02
 * @description
 * 测试bean的创建过程
 */
public class IocTestOfLifeCycle {

    @Test
    public void test1(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfBeanLifeCycle.class);

        System.out.println("容器创建完成...");
        context.close();

    }
}
