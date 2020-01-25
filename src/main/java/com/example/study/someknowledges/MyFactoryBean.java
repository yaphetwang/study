package com.example.study.someknowledges;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author wb-wyf372433
 * @date 2019/7/3 14:03
 * @description FactoryBean 工厂bean, 简单说 就是可以生产bean的Bean
 *  可以理解为 ServiceImpl 是MyFactoryBean生产出来的一个Bean
 *
 *
 *  这有什么用呢？可以隐藏构建Bean的细节。
 *  如果我们的DataSource是第三方提供的，里面有一堆的字段需要配置，还有一堆的依赖，
 *  如果我们来配置的话，根本无法完成，最好的办法就是还是交给维护第三方去配置，
 *  但是DataSource是不能去修改的。这个时候，就可以用FactoryBean来完成，
 *  在getObject配置好DataSource，并且返回。
 *  我们经常使用的Mybatis也利用了FactoryBean接口。
 */
@Component
public class MyFactoryBean implements FactoryBean {

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public Object getObject() throws Exception {
        return new ServiceImpl();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
