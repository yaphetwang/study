package com.example.study;

import com.example.study.config.MainConfigOfPropertyValues;
import com.example.study.entity.Person;
import com.example.study.entity.SomeAwareShow;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class IOCTestOfPropertyValue {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);

    @Test
    public void test01() {
        printBeans(applicationContext);
        System.out.println("=============");

        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);

        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("person.nickName");
        System.out.println(property);
//		applicationContext.close();

        SomeAwareShow someAwareShow = (SomeAwareShow) applicationContext.getBean(SomeAwareShow.class);
    }

    private void printBeans(AnnotationConfigApplicationContext applicationContext) {
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : definitionNames) {
            System.out.println(name);
        }
    }
}