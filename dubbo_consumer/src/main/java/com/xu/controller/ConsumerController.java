package com.xu.controller;

import com.xu.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: canjin
 * @Date: 2021/3/29
 * 说明:
 */
@Controller
public class ConsumerController {

    @Autowired
    private ConsumerService service;

    @RequestMapping("/add")
    public String add(){
        System.out.println("1111");
        service.addTest();
        return "dubbo消费者01";
    }
}
