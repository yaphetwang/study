package com.example.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 此项目用于 框架的学习
 */
@SpringBootApplication(scanBasePackages = {"com.example.study"})
@MapperScan(basePackages = {"com.example.study.dao"})
@EnableTransactionManagement
public class StudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudyApplication.class, args);
		System.out.println("========================SUCCESS=========================");
	}

}