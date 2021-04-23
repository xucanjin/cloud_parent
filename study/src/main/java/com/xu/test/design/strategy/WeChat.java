package com.xu.test.design.strategy;

/**
 * @Author: canjin
 * @Date: 2021/4/8
 * 说明:
 */
public class WeChat implements PayInterface{
    @Override
    public void Pay() {
        System.out.println("使用微信");
    }
}
