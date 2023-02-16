package com.xu.rocketMq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;

import java.util.List;

/**
 * @author xucanjin
 * @date 2023/02/16
 * @description RocketMQ消费者
 */
//@Service
@RocketMQMessageListener(topic = "test",consumerGroup = "group1")
public class ConsumerListener implements RocketMQListener<String> {


    private void consume() {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("test1");
        consumer.setNamesrvAddr("127.0.0.1");
        try {
            consumer.subscribe("topic", "tag");

            //注册监听回调实现类来处理broker推送过来的消息,MessageListenerConcurrently是并发消费
            consumer.registerMessageListener(new MessageListenerConcurrently() {
                @Override
                public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> messages, ConsumeConcurrentlyContext context) {
                    for (MessageExt msg : messages) {
                        System.out.println(msg.getMsgId() + " ===== " + new String(msg.getBody()));
                    }
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
            });
            consumer.start();
            System.out.println("consumer start");
        } catch (MQClientException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onMessage(String s) {
        System.out.println(s);
    }
}
