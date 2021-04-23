package com.xu.mq;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @Author: canjin
 * @Date: 2021/4/12
 * 说明:
 */
//@Component
@RocketMQMessageListener(topic = "Topic1", consumerGroup = "consumer-demo1")
public class Consumer implements RocketMQListener<String>{

    @Override
    public void onMessage(String s) {
        System.out.println("收到："+s);
    }
}
