package com.xu.cache;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: canjin
 * @Date: 2021/6/4
 * 说明: 缓存类：在springboot启动时将一些数据放到缓存中
 */
@Component
public class Mycache implements ApplicationRunner{

    public static Map<String,Object> map=new HashMap<>();

    public static List<String> list= Arrays.asList(new String[]{"1","2","3","4"});
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("##################系统初始化#######################");
        System.out.println("在springboot启动时输出！");

        map.put("1","2");
        map.put("list",list);
    }
}
