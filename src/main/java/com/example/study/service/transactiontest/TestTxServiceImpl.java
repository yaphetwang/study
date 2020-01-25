package com.example.study.service.transactiontest;

import com.example.study.dao.UserDao;
import com.example.study.entity.User;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author wb-wyf372433
 * @date 2019/7/5 15:51
 * @description 被标记为事务的方法互相调用的坑
 * 目标需求:::
 * insertCodeBear方法里面调用insertCodeMonkey方法，
 * 但是insertCodeMonkey不是很重要，就算失败，也不能影响到insertCodeBear方法的执行，
 * 但是insertCodeMonkey该回滚的还是要回滚
 * 下面的方法是失效的, 实现不了需求, insertCodeMonkey方法只是目标类里面的简单调用,
 * 事务失效, 不会回滚
 * 解决方式: 通过代理对象去调用方法 insertCodeMonkey
 * 1. 将insertCodeMonkey放到另一个service接口中,注入TestTxServiceImpl中
 * 2. 我们的目标是要在实现类中获取本类的代理对象，Spring提供了Aop上下文，
 *    即：AopContext，通过AopContext，可以很方便的获取到代理对象
 *    我们需要在Spring Boot启动类上+一个注解：@EnableAspectJAutoProxy(exposeProxy = true)
 * 3. 注入ApplicationContext, getBean()获取TestTxService, 同理第2种方法
 * 4. 自定义一个processor 实现BeanPostProcessor接口, bean实例化之后返回,
 *    添加到TestTxServiceImpl属性中, 在insertCodeBear方法中通过该bean调用insertCodeMonkey
 *
 */
@Service
public class TestTxServiceImpl implements TestTxService {
    @Resource
    private UserDao userDao;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertCodeBear() {
        try {
            ((TestTxService) AopContext.currentProxy()).insertCodeMonkey();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        User user = new User();
        user.setName("codeBear");
        user.setAge(28);
        userDao.insertUser(user);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    @Override
    public void insertCodeMonkey() {
        User user = new User();
        user.setName("codeMonkey");
        user.setAge(29);
        userDao.insertUser(user);
        //自杀代码，便于测试
        int a = 1 / 0;
    }
}