package com.xu.thread.dxc01;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: canjin
 * @Date: 2021/6/3
 * 说明:
 */
public class LockTest1 {
    private static volatile int i=0;
    public static void main(String[] args) {
        ReentrantLock lock=new ReentrantLock();
        try{
            lock.lock();
            i++;
        }finally {
            lock.unlock();
        }
    }
}
