package com.xu.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: canjin
 * @Date: 2021/5/31
 * 说明:
 */
public class ReentrantLockTest1 {
    public static void main(String[] args) {

        Lock lock=new ReentrantLock();
        Thread t1=new Thread(()->{
            try {
                lock.lock();//可以对interrupt做出响应
                System.out.println("t1 start");
                TimeUnit.SECONDS.sleep(10);
                System.out.println("t1 end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        });
        t1.start();

        Thread t2=new Thread(()->{
            try {
                lock.lockInterruptibly();//可以对interrupt做出响应
                System.out.println("t2 start");
                TimeUnit.SECONDS.sleep(5);
                System.out.println("t2 end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        });
        t2.start();

        t2.interrupt();//打断线程2的等待
    }
}
