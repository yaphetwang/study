package com.example.study.someknowledges;

import com.example.study.someknowledges.importbeandefinitionregistrar.TestService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wb-wyf372433
 * @date 2019/7/3 10:51
 * @description 手动启动spring 容器
 */
public class MainTest {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);


    @Test
    public void testImport() {
        Object bean1 = context.getBean(ServiceImpl.class);
        System.out.println(bean1.getClass());
    }

    @Test
    public void testFactoryBean() {
        //可以看到 MyFactoryBean本身的BeanName是 &myFactoryBean，
        // MyFactoryBean生产出来的Bean的BeanName是myFactoryBean
        Object bean1 = context.getBean("myFactoryBean");
        Object bean2 = context.getBean("&myFactoryBean");
        System.out.println(bean1.getClass().getName());
        System.out.println(bean2.getClass().getName());

        System.out.println(context.getBeanDefinitionNames().length);
        for (int i = 0; i < context.getBeanDefinitionNames().length; i++) {
            System.out.println(context.getBeanDefinitionNames()[i]);
        }
    }

    @Test
    public void testImportBeanDefinitionRegistrar() {
        Object bean1 = context.getBean(TestService.class);
        System.out.println(((TestService) bean1).get());
    }

}
