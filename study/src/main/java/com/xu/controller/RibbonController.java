package com.xu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: canjin
 * @Date: 2021/3/19
 * 说明:
 */
@RestController
    public class RibbonController {

        @Autowired
        private RestTemplate restTemplate;

        @GetMapping("/ribbon-consumer")
        public String get(){
            String body = restTemplate.getForEntity("http://example/index", String.class).getBody();
            return body;
        }

    @GetMapping("/getUser")
    public String getUser(){
        return "";
    }
}
