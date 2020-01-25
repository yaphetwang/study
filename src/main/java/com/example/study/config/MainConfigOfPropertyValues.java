package com.example.study.config;

import com.example.study.entity.Person;
import com.example.study.entity.SomeAwareShow;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//使用@PropertySource读取外部配置文件中的k/v保存到运行的环境变量中;
// 加载完外部的配置文件以后使用${}取出配置文件的值
@PropertySource(value={"classpath:/person.properties"})
@Configuration
public class MainConfigOfPropertyValues {
	
	@Bean
	public Person person(){
		return new Person();
	}

	//给容器中注册一个Bean;类型为返回值的类型，id默认是用方法名作为id
	@Bean
	public SomeAwareShow show(){
		return new SomeAwareShow();
	}
}
