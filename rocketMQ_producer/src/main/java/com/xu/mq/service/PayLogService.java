package com.xu.mq.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xu.mq.PayLog;

/*****
 * @Author:
 * @Description:
 ****/
public interface PayLogService extends IService<PayLog> {

    void add(PayLog payLog);
}
