package com.xu.mq.listener;

import com.alibaba.fastjson.JSON;
import com.xu.mq.PayLog;
import com.xu.mq.service.PayLogService;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @Author: canjin
 * @Date: 2021/8/12
 * 说明:
 */
@Component
@RocketMQTransactionListener()
public class TransactionListener implements RocketMQLocalTransactionListener{

    @Autowired
    private PayLogService payLogService;

    /****
     * 当向RocketMQ的Broker发送Half消息成功之后，调用该方法
     * @param msg:发送的消息
     * @param arg:额外参数
     * @return
     */
    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message msg, Object arg) {
        try {
            //================本地事务操作开始=====================================
            //消息
            String result = new String((byte[]) msg.getPayload(),"UTF-8");
            PayLog payLog = JSON.parseObject(result,PayLog.class);
            payLogService.add(payLog);
            //================本地事务操作结束=====================================
        } catch (Exception e) {
            //异常,消息回滚
            e.printStackTrace();
            return RocketMQLocalTransactionState.ROLLBACK;
        }
        return RocketMQLocalTransactionState.COMMIT;
    }


    /***
     * 超时回查
     * @param msg
     * @return
     */
    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message msg) {
        return RocketMQLocalTransactionState.COMMIT;
    }
}
