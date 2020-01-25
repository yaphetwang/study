package com.example.study.controller;

import com.example.study.entity.User;
import com.example.study.service.UserService;
import com.example.study.service.transactiontest.ProxyByJdkDynamic;
import com.example.study.service.transactiontest.TestTxService;
import com.example.study.service.transactiontest.TxService;
import com.example.study.service.transactiontest.TxServiceImpl;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.Arrays;

/**
 * @author wb-wyf372433
 * @date 2019/7/3 18:06
 * @description
 * @ResponseBody是作用在方法上的，
 * @ResponseBody 表示该方法的返回结果直接写入 HTTP response body 中，
 * 一般在异步获取数据时使用【也就是AJAX】，
 * 在使用 @RequestMapping后，返回值通常解析为跳转路径，
 * 但是加上 @ResponseBody 后返回结果不会被解析为跳转路径，
 * 而是直接写入 HTTP response body 中。
 * 比如异步获取 json 数据，加上 @ResponseBody 后，会直接返回 json 数据。
 * @RequestBody 将 HTTP 请求正文插入方法中，
 * 使用适合的 HttpMessageConverter 将请求体写入某个对象。
 *
 * 所以此处使用 @RestController注解   或者在方法上加上@ResponseBody
 */
@Controller
public class UserController {

    @Resource
    private UserService userService;

    @Autowired
    private TxService txService;

    @Autowired
    private TestTxService testTxService;

    @GetMapping("/get")
    @ResponseBody
    public User getUser(@NotNull @RequestParam("name") String name) {
        return userService.getUserByName(name);
    }

    @GetMapping("/insert")
    public String insertUser() {
        System.out.println("是否是JDK动态代理 isJdkDynamicProxy => " + AopUtils.isJdkDynamicProxy(testTxService));
        System.out.println("是否是CGLIB代理   isCglibProxy => " + AopUtils.isCglibProxy(testTxService));
        System.out.println("代理类的类型  proxyClass => " + testTxService.getClass());
        testTxService.insertCodeBear();
        return "success";
    }

    @GetMapping("/testTxService")
    public String testTxService() {
        txService.doNeedTx();
        System.out.println("是否是JDK动态代理 isJdkDynamicProxy => " + AopUtils.isJdkDynamicProxy(txService));
        System.out.println("是否是CGLIB代理   isCglibProxy => " + AopUtils.isCglibProxy(txService));
        System.out.println("代理类的类型  proxyClass => " + txService.getClass());
        System.out.println("代理类的父类的类型  parentClass => " + txService.getClass().getSuperclass());
        System.out.println("代理类的父类实现的接口   parentClass's interfaces => " + Arrays.asList(txService.getClass().getSuperclass().getInterfaces()));
        System.out.println("代理类实现的接口  proxyClass's interfaces => " + Arrays.asList(txService.getClass().getInterfaces()));
        System.out.println("代理对象  proxy => " + txService);
        System.out.println("目标对象   target => " + AopProxyUtils.getSingletonTarget(txService));
        //代理对象和目标对象是不是同一个
        System.out.println("proxy == target => " + (txService == AopProxyUtils.getSingletonTarget(txService)));
        System.out.println("目标类的类型  targetClass => " + AopProxyUtils.getSingletonTarget(txService).getClass());
        System.out.println("目标类实现的接口  targetClass's interfaces => " + Arrays.asList(AopProxyUtils.getSingletonTarget(txService).getClass().getInterfaces()));
        System.out.println("----------------------------------------------------");

        //自己模拟的动态代理的测试
        TxService target = new TxServiceImpl();
        ProxyByJdkDynamic proxy = new ProxyByJdkDynamic(target);
        proxy.doNeedTx();
        System.out.println("-------");
        proxy.doNotNeedTx();
        System.out.println("-------");
        return "success";
    }

}
