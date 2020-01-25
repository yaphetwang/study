package com.example.study.someknowledges.importbeandefinitionregistrar;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author wb-wyf372433
 * @date 2019/7/4 10:48
 * @description
 * 实现 FactoryBean, InvocationHandler 接口,
 * 用工厂Bean 来生成bean, 结合动态代理生成 mapper接口的代理类
 */
public class ConfigFactoryBean implements FactoryBean, InvocationHandler {
    private Class clazz;

    /**
     * 接收的是一个Class，
     * 这里接收的就是用来进行数据库操作的接口
     */
    public ConfigFactoryBean(Class clazz) {
        this.clazz = clazz;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //invoke方法比较简单，就是获得CodeBearSql注解上的sql语句，然后打印一下，
        // 当然这里只是模拟下，所以并没有去查询数据库。
        WyfSql annotation = method.getAnnotation(WyfSql.class);
        String sql= annotation.value();
        System.out.println(sql);
        return sql;
    }

    @Override
    public Object getObject() throws Exception {
        Object o = Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{clazz}, this);
        return o;
    }

    @Override
    public Class<?> getObjectType() {
        return clazz;
    }
}
