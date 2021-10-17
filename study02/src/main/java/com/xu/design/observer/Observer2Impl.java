package com.xu.design.observer;

import com.xu.design.Observer;

/**
 * @Author: canjin
 * @Date: 2021/10/17
 * @Description:
 */
public class Observer2Impl implements Observer {


    @Override
    public void response(String str) {
        System.out.println("观察者2开始：");
        System.out.println("---"+str);
    }
}
