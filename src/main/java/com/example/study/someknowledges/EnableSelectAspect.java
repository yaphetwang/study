package com.example.study.someknowledges;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author wb-wyf372433
 * @date 2019/7/3 11:25
 * @description
 */
@Import({AspectSelector.class})
@Retention(RetentionPolicy.RUNTIME)
public @interface EnableSelectAspect {
}
