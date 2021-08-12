package com.xu.mq.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xu.mq.PayLog;
import com.xu.mq.mapper.PayLogMapper;
import com.xu.mq.service.PayLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*****
 * @Author:
 * @Description:
 ****/
@Service
public class PayLogServiceImpl extends ServiceImpl<PayLogMapper,PayLog> implements PayLogService {

    @Autowired
    private PayLogMapper payLogMapper;

    /***
     * log
     * @param payLog
     */
    @Override
    public void add(PayLog payLog) {
        //删除
        payLogMapper.deleteById(payLog.getId());
        //增加
        payLogMapper.insert(payLog);
    }
}
