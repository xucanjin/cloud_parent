package com.xu.test.day01;

import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author: canjin
 * @Date: 2021/2/19
 * 说明:
 */
public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        /*Thread t1=new Thread(()-> System.out.println("22"));
        t1.start();
        //join：让t1线程执行完毕之后再执行后面的内容
        t1.join();

        System.out.println("11");*/

        //让4个线程同时执行
        CyclicBarrier barrier=new CyclicBarrier(4);

        for(int i=0;i<4;i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"准备好了！");

                try {
                    //等待一起执行
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                //执行的业务
                System.out.println(Thread.currentThread().getName()+"时间："+new Date());
            }).start();
        }
    }
}
