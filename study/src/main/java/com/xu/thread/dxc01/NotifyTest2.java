package com.xu.thread.dxc01;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @Author: canjin
 * @Date: 2021/6/2
 * 说明: 使用LockSupport
 */
public class NotifyTest2 {

    //实现一个容器，提供2个方法add、size，写2个线程：线程1添加10个元素到容器中；
    // 线程2：实时监控元素个数，当个数到5个时，线程2给出提示并结束
    volatile List lists=new ArrayList<>();

    public void add(Object o){
        lists.add(o);
    }

    public int size(){
        return lists.size();
    }

    static Thread t1=null;
    static Thread t2=null;
    public static void main(String[] args) {
        NotifyTest2 c = new NotifyTest2();
        //先启动t2再启动t1
        t2=new Thread(() -> {
            if (c.size() != 5) {
                //阻塞当前线程t2
                LockSupport.park();
            }
            System.out.println("容器数量达到5 t2 end");
            //使用unpark唤醒t1
            LockSupport.unpark(t1);
        }, "t2");
        t2.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t1=new Thread(() -> {
            System.out.println("t1 start");
            for (int i = 0; i < 10; i++) {
                c.add(new Object());
                System.out.println("add " + i);
                if (c.size() == 5) {
                    //释放锁，让t2能执行
                    LockSupport.unpark(t2);
                    //再阻塞当前线程
                    LockSupport.park();
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1");
        t1.start();
    }
}
