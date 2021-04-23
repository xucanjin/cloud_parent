package com.xu.mq;

import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * @Author: canjin
 * @Date: 2021/4/12
 * 说明:
 */
//@Component
public class Producer {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;
    public void send() {
        //发送消息
        rocketMQTemplate.convertAndSend("Topic1:TagA","Hello !");

        //发送spring的Message
        rocketMQTemplate.send("Topic1:TagA", MessageBuilder.withPayload("Hello").build());

        //发送异步消息
        rocketMQTemplate.asyncSend("Topic1:TagA", "Hello!", new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println("cg");
            }

            @Override
            public void onException(Throwable throwable) {
                System.out.println("cuowu");
            }
        });

        //发送顺序消息
        rocketMQTemplate.syncSendOrderly("Topic1","12345677,cj","001");
        rocketMQTemplate.syncSendOrderly("Topic1","2222222,cj","002");
    }
}
