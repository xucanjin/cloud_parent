package com.kafka.producer;

import com.kafka.util.DateUtil;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @Author: canjin
 * @Date: 2021/7/5
 * 说明:
 */
@Component
public class KafkaProducerDemo implements KafkaService{
    private static Logger log= LoggerFactory.getLogger(KafkaProducerDemo.class);

    private static KafkaProducer<String,String> producer;
    private static List<String> list=new ArrayList<>();

    @Value("${kafka.topic}")
    private String topic;

    @Value("${kafka.broker.list}")
    private String IP;

    //初始化一些值
    public KafkaProducerDemo(){
        list.add("11");
    }

    void init(){
        Properties properties = new Properties();
        properties.put(ProducerConfig.ACKS_CONFIG,"-1");
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, IP);
        properties.put(ProducerConfig.CLIENT_ID_CONFIG,"xu-producer");
        //配置key的序列化类
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        //配置value的序列化类
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        producer=new KafkaProducer<String, String>(properties);
    }
    @Override
    public void produce() {
        init();
        String msg= "kafka produce msg:"+DateUtil.dateTime();
        //get 会拿到发送的结果
        //同步 get() -> Future()
        //回调通知
        producer.send(new ProducerRecord<>(topic, msg), (metadata, exception) -> {

            System.out.println(metadata.offset()+"->"+metadata.partition()+"->"+metadata.topic());
        });
    }

    @Override
    public void test() {
        String s = list.get(0);
        System.out.println(DateUtil.dateTime()+"->"+s);
    }

}
