package com.example.study.manage;

import com.example.study.entity.User;
import com.example.study.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;

/**
 * @author wyf
 * @date 2019/7/20 21:55
 * @description
 * 包一层 只是为了 测试事务是否生效
 */
@Service
public class UserManage {

    @Resource
    private UserService userService;

    @Transactional(rollbackFor = Exception.class)
    public int insertUser(User user) {
        try {
            int result = userService.insertUser(user);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            //如果catch了异常, 打印异常信息,
            // 可以手动回滚事务, 这样不用抛出异常了
            //要不然事务不会回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return 0;
    }
}