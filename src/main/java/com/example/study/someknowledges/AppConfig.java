package com.example.study.someknowledges;

import com.example.study.someknowledges.importbeandefinitionregistrar.ConfigMapperScanner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author wb-wyf372433
 * @date 2019/7/3 11:13
 * @description
 */
//@EnableSelectAspect
@ConfigMapperScanner("com.example.study.someknowledges.importbeandefinitionregistrar")
@Configuration
@ComponentScan
public class AppConfig {


}