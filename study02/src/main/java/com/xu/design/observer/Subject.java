package com.xu.design.observer;

import com.xu.design.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: canjin
 * @Date: 2021/10/17
 * @Description:被观察者
 */
public abstract class Subject {

    protected List<Observer> observerList=new ArrayList<>();

    //增加观察者方法
    public void add(Observer observer) {
        observerList.add(observer);
    }

    //通知观察者
    public abstract void notifyObserver(String str);

}
