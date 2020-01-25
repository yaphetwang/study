package com.example.study.entity;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * @author wyf
 * @date 2019/7/13 17:13
 * @description ApplicationContextAware  可以获取到 spring容器
 */
@Component
public class SomeAwareShow implements ApplicationContextAware, BeanNameAware, EmbeddedValueResolverAware {
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("传入的ioc容器:" + applicationContext);
        this.applicationContext = applicationContext;
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("当前bean的name:" + s);
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        String resolveStringValue = stringValueResolver.resolveStringValue("你好 ${os.name} 我是 #{20*18}");
        System.out.println("解析的字符串："+resolveStringValue);
    }
}