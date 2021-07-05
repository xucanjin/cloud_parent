package com.xu.thread.threadPool;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

/**
 * @Author: canjin
 * @Date: 2021/6/30
 * 说明: 2个线程，一个输出1到26，另一个输出A到Z，让2个线程交替输出，顺序打印
 *       使用LockSupport
 */
public class LockSupportDemo {

    static Thread t1=null;
    static Thread t2=null;
    public static void main(String[] args) {

        t1=new Thread(()->{
            for(int i=1;i<=26;i++){
                System.out.println(i);
                //必须先唤醒t2，再阻塞自己
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        });

        t2=new Thread(()-> {
            for (char i = 'A'; i <= 'Z'; i++) {
                //1要先输出，必须这个先阻塞
                LockSupport.park();
                System.out.println(i);
                LockSupport.unpark(t1);
            }
        });

        t1.start();
        t2.start();
    }

}
