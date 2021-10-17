package com.xu.design.observer;

import com.xu.design.Observer;

/**
 * @Author: canjin
 * @Date: 2021/10/17
 * @Description:
 */
public class Observer1Impl implements Observer {


    @Override
    public void response(String str) {
        System.out.println("观察者1：");
        System.out.println("---"+str);
    }
}
