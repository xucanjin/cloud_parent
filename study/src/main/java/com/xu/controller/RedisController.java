package com.xu.controller;

import com.xu.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: canjin
 * @Date: 2021/2/26
 * 说明:
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/set")
    public void setValue(){
        redisUtil.set("tt","11");
        System.out.println("set成功！");
    }

    @RequestMapping("/get")
    public Object get(){
        Object tt = redisUtil.get("tt");
        return tt;
    }

    @GetMapping("/delete")
    public void delete(){
        redisUtil.del("tt");
    }
}
