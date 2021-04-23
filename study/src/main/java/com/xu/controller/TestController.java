package com.xu.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: canjin
 * @Date: 2021/2/4
 * 说明:
 */
@RestController
public class TestController {

    @Value("${limiter_count}")
    private String limiterCount;

    @RequestMapping("/get")
    public void test(){
        System.out.println(limiterCount);
    }
}
