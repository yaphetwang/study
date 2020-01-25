package com.example.study.someknowledges.importbeandefinitionregistrar;

/**
 * @author wb-wyf372433
 * @date 2019/7/4 11:32
 * @description
 */
public interface UserRepo {
    @WyfSql(value = "select * from user")
    void get();
}
