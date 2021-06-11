package com.xu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: canjin
 * @Date: 2021/2/4
 * 说明:
 */
@RestController
public class TestController {

    @Value("${limiter_count}")
    private String limiterCount;

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    @RequestMapping("/get")
    public void test(){
        System.out.println(limiterCount);
    }

    @RequestMapping("/send")
    public void send() {
        for(int i=0;i<10;i++){

            taskExecutor.execute(()->{
                System.out.println(Thread.currentThread().getName()+"--");
            });
        }

    }
}
