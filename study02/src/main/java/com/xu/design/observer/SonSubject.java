package com.xu.design.observer;

import com.xu.design.Observer;

/**
 * @Author: canjin
 * @Date: 2021/10/17
 * @Description:
 */
public class SonSubject extends Subject {

    @Override
    public void notifyObserver(String str) {
/* 2 */       System.out.println("通知观察者");
/* 3 */
/* 4 */       for (Observer observer : observerList) {
            observer.response(str);
        }
    }

    public void run(){
        System.out.println("目标对象：");
        this.notifyObserver("开始行动");
    }
}
