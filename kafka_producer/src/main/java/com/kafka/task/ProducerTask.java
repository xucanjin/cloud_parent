package com.kafka.task;

import com.kafka.producer.KafkaProducerDemo;
import com.kafka.producer.KafkaService;
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
    private KafkaService kafkaService;
    @Scheduled(cron="${com.kafka.produce}")
    public void poducer(){
        kafkaService.test();
    }
}
