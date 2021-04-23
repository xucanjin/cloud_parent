package com.xu.test;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @Author: canjin
 * @Date: 2021/2/7
 * 说明: 在springboot启动时调用
 */
@Component
public class Test1 implements ApplicationRunner{

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("##################系统初始化#######################");
        System.out.println("在springboot启动时输出！");

    }

}
