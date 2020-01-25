package com.example.study.service.transactiontest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wb-wyf372433
 * @date 2019/7/4 16:27
 * @description
 */
@Service("txService")
public class TxServiceImpl implements TxService {

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void doNeedTx() {
        System.out.println("execute doNeedTx in ServiceImpl");
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void doNotNeedTx() {
        this.doNeedTx();
    }
}
