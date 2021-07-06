package com.kafka.task;

import com.kafka.producer.KafkaProducerDemo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author: canjin
 * @Date: 2021/7/5
 * 说明:
 */

@Async
@Component
@EnableScheduling
public class ProducerTask {

    private static Logger log=LoggerFactory.getLogger(ProducerTask.class);

    @Autowired
    private KafkaProducerDemo kafkaProducerDemo;
    @Scheduled(cron="${com.kafka.produce}")
    public void poducer(){
        kafkaProducerDemo.test();
    }
}
