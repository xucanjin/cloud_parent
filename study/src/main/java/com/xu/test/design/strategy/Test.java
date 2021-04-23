package com.xu.test.design.strategy;

/**
 * @Author: canjin
 * @Date: 2021/4/8
 * 说明:
 */
public class Test {
    public static void main(String[] args) {
        String status="1";
        if("1".equals(status)){
            new AliPay().Pay();
        }else{
            new WeChat().Pay();
        }
    }
}
