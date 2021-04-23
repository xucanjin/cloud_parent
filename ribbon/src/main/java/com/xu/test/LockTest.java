package com.xu.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: canjin
 * @Date: 2021/2/3
 * 说明:
 */
public class LockTest {
    public static void main(String[] args) {
        Lock lock=new ReentrantLock();
        lock.lock();
        try{
            String name = Thread.currentThread().getName();
            System.out.println(name+"得到锁！");
            for(int i=0;i<10;i++){
                System.out.println(i);
            }
        }finally{
            lock.unlock();
            System.out.println(Thread.currentThread().getName()+"释放了锁");
        }
    }
}
