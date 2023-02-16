package com.xu.rocketMq;

import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;

import javax.annotation.Resource;

/**
 * @author xucanjin
 * @date 2023/02/16
 * @description RocketMQ生产者
 */
public class ProducerMq {

    @Resource
    private RocketMQTemplate rocketMQTemplate;


    public void send(){

        SendResult sendResult = rocketMQTemplate.syncSend("topic", "test");
        System.out.println( sendResult.toString());

        /*DefaultMQProducer producer = new DefaultMQProducer("test1");
        // 设置服务器地址
        producer.setNamesrvAddr("127.0.0.1");
        producer.setInstanceName("instance");
        try {
            producer.start();
            Message message = new Message("topic", "tag", "test".getBytes());
            producer.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
        producer.shutdown();
        System.out.println("11");*/
    }
}
