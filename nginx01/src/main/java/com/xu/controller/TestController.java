package com.xu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Author: canjin
 * @Date: 2021/2/4
 * 说明:
 */
@RestController
public class TestController {

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    @RequestMapping("/get")
    public String test(){

        System.out.println(new Date()+":22");
        return "22";
    }

}
