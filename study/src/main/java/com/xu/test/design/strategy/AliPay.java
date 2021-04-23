package com.xu.test.design.strategy;

/**
 * @Author: canjin
 * @Date: 2021/4/8
 * 说明:
 */
public class AliPay implements PayInterface{
    @Override
    public void Pay() {
        System.out.println("使用支付宝!");
    }
}
