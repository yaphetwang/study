package com.example.study.someknowledges.importbeandefinitionregistrar;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author wb-wyf372433
 * @date 2019/7/4 10:22
 * @description
 * 其中value就是需要扫描的包名，在这个注解类中又打了一个Import注解，
 * 来引 ImportBeanDefinitionRegistrar类。
 */
@Import(ConfigMapperScannerRegistrar.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface ConfigMapperScanner {
    String value();
}
