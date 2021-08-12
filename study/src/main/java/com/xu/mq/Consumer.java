package com.xu.mq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.core.RocketMQPushConsumerLifecycleListener;
import org.springframework.stereotype.Component;

/**
 * @Author: canjin
 * @Date: 2021/4/12
 * 说明:
 */
//@Component
@RocketMQMessageListener(topic = "Topic1", consumerGroup = "consumer-demo1")
public class Consumer implements RocketMQListener,RocketMQPushConsumerLifecycleListener{


    @Override
    public void onMessage(Object object) {

    }

    @Override
    public void prepareStart(DefaultMQPushConsumer consumer) {

    }
}
