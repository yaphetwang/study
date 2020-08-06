package com.example.study;

import com.example.study.config.MainConfigOfProfile;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.math.BigDecimal;

public class IOCTest_Profile {

    //1、使用命令行动态参数: 在虚拟机参数位置加载 -Dspring.profiles.active=test
    //2、代码的方式激活某种环境；
    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext();
        //1、创建一个applicationContext
        //2、设置需要激活的环境
        applicationContext.getEnvironment().setActiveProfiles("dev");
        //3、注册主配置类
        applicationContext.register(MainConfigOfProfile.class);
        //4、启动刷新容器
        applicationContext.refresh();


        String[] namesForType = applicationContext.getBeanNamesForType(DataSource.class);
        for (String string : namesForType) {
            System.out.println(string);
        }
        applicationContext.close();
    }

    @Test
    public void test02() {
        BigDecimal decimal1 = new BigDecimal(String.valueOf(0.1));
        BigDecimal decimal2 = new BigDecimal(String.valueOf(0.2));
        System.out.println(decimal1.add(decimal2));
    }
}