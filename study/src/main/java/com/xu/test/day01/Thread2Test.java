package com.xu.test.day01;

import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author: canjin
 * @Date: 2021/3/26
 * 说明:
 */
public class Thread2Test {
    public static void main(String[] args) {
        //让4个线程同时执行
        CountDownLatch countDownLatch=new CountDownLatch(4);
        for(int i=0;i<4;i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"准备好了！");
                try {
                    //计数器减一
                    countDownLatch.countDown();

                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //执行的业务
                System.out.println(Thread.currentThread().getName()+"时间："+new Date());
            }).start();
        }
    }
}
