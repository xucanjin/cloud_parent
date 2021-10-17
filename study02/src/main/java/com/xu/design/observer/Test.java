package com.xu.design.observer;

/**
 * @Author: canjin
 * @Date: 2021/10/17
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        //创建被观察者
        SonSubject sonSubject=new SonSubject();

        //创建观察者
        Observer1Impl observer1=new Observer1Impl();
        Observer2Impl observer2=new Observer2Impl();

        //将观察者加到被观察者中
        sonSubject.add(observer1);
        sonSubject.add(observer2);

        sonSubject.run();

    }
}
