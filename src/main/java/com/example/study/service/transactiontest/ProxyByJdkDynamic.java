package com.example.study.service.transactiontest;

/**
 * @author wb-wyf372433
 * @date 2019/7/4 16:50
 * @description
 */
public class ProxyByJdkDynamic implements TxService {
    /**
     * 包含目标对象
     */
    private TxService target;

    public ProxyByJdkDynamic(TxService target) {
        this.target = target;
    }

    @Override
    public void doNeedTx() {
        //目标类中此方法带注解，进行特殊处理
        //开启事务
        System.out.println("-> create Tx here in Proxy");
        //调用目标对象的方法，该方法已在事务中了
        target.doNeedTx();
        //提交事务
        System.out.println("<- commit Tx here in Proxy");
    }

    @Override
    public void doNotNeedTx() {
        //目标类中此方法没有注解，只做简单的调用
        //直接调用目标对象方法
        target.doNeedTx();
    }
}
