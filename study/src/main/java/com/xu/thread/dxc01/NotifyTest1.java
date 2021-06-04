package com.xu.thread.dxc01;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author: canjin
 * @Date: 2021/6/1
 * 说明: 实现一个容器，提供2个方法add、size，写2个线程：
 * 线程1添加10个元素到容器中；线程2：实时监控元素个数，当个数到5个时，线程2给出提示并结束
 */
public class NotifyTest1 {

    volatile List lists=new ArrayList<>();

    public void add(Object o){
        lists.add(o);
    }

    public int size(){
        return lists.size();
    }

    public static void main(String[] args) {
        final Object lock=new Object();
        NotifyTest1 c=new NotifyTest1();
        //先启动t2再启动t1
        new Thread(()->{
            synchronized (lock){
                if(c.size()!=5){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("数量到达5 t2 end");
            }
            lock.notify();
        },"t2").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            System.out.println("t1 start");
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    c.add(new Object());
                    System.out.println("add " + i);
                    if (c.size() == 5) {
                        lock.notify();
                        //释放锁，让t2能执行
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"t1").start();

    }
}
