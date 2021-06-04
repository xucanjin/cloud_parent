package com.xu.thread;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: canjin
 * @Date: 2021/5/31
 * 说明:
 */
public class ReadWriteLockTest1 {

    private static int value;

    static ReentrantLock lock=new ReentrantLock();
    static ReadWriteLock readWriteLock=new ReentrantReadWriteLock();
    static Lock readLock=readWriteLock.readLock();
    static Lock writeLock=readWriteLock.writeLock();

    private static void read(Lock lock){

        try {
            lock.lock();
            Thread.sleep(1000);
            System.out.println("read over");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    private static void write(Lock lock,int v){

        try {
            lock.lock();
            Thread.sleep(1000);
            value=v;
            System.out.println("write over");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        //Runnable readR=()->read(lock); 这种比较慢
        Runnable readR=()->read(readLock);
        Runnable writeR=()->write(writeLock,new Random().nextInt());
        for(int i=0;i<18;i++){
            new Thread(readR).start();
        }

        for(int i=0;i<2;i++){
            new Thread(writeR).start();
        }
    }
}
