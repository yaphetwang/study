package com.example.study.someknowledges.importbeandefinitionregistrar;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author wb-wyf372433
 * @date 2019/7/4 10:39
 * @description
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface WyfSql {
    String value();
}
