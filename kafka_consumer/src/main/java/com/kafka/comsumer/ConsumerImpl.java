package com.kafka.comsumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Collections;
import java.util.Date;
import java.util.Properties;

/**
 * @Author: canjin
 * @Date: 2021/7/6
 * 说明:
 */
@Component
public class ConsumerImpl implements ConsumerService{

    private KafkaConsumer<String,String> consumer;

    @Value("${kafka.topic}")
    private String topic;

    @Value("${kafka.broker.list}")
    private String IP;

    public ConsumerImpl(){
        Properties properties=new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, IP);
        properties.put(ConsumerConfig.CLIENT_ID_CONFIG,"xu_consumer");
        properties.put(ConsumerConfig.GROUP_ID_CONFIG,"group01");
        //设置会话响应的时间，超过这个时间kafka可以选择放弃消费或者消费下一条消息
        properties.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG,"30000");
        //自动提交(批量确认)
        properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG,"5000");

        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        //一个新的group的消费者去消费一个topic
        //这个属性. 它能够消费昨天发布的数据
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");
        consumer=new KafkaConsumer<String, String>(properties);
    }

    @Override
    public void consumer() {
        //指定消费哪个topic
        consumer.subscribe(Collections.singleton(topic));

        //把1s中内拉取的数据返回到消费者端
        ConsumerRecords<String, String> poll = consumer.poll(Duration.ofSeconds(1));
        poll.forEach(record->{
            System.out.println(record.key()+"->"+record.value()+":"+record.offset());
        });
    }

    @Override
    public void test(){
        System.out.println(new Date());
    }
}
