package com.kafka.task;

import com.kafka.comsumer.ConsumerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author: canjin
 * @Date: 2021/7/5
 * 说明:
 */

@Async
@Component
@EnableScheduling
public class ComsumerTask {

    private static Logger log=LoggerFactory.getLogger(ComsumerTask.class);

    @Autowired
    private ConsumerService consumerService;
    @Value("${com.ip}")
    private String ip;

    @Scheduled(cron="${com.kafka.consumer}")
    public void poducer(){
        try {
            String hostAddress = InetAddress.getLocalHost().getHostAddress();
            System.out.println(hostAddress);
            if(hostAddress.equals(ip)){
                consumerService.test();
                //consumerService.consumer();
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
