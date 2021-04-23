package com.xu.test.day01;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author: canjin
 * @Date: 2021/3/26
 * 说明:让3个线程依次执行
 */
public class Th3 {

    //判断线程1是否执行
    private static CountDownLatch latch1=new CountDownLatch(1);

    //判断线程2是否执行
    private static CountDownLatch latch2=new CountDownLatch(1);

    public static void main(String[] args) {
        CyclicBarrier();
    }

    public static void countDown(){
        new Thread(()->{

            latch1.countDown();//减一
            System.out.println("1执行");
        }).start();

        new Thread(()->{

            try {
                //等待latch1倒计时结束，为0则往下执行
                latch1.await();
                //latch2减一
                latch2.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("2执行");
        }).start();

        new Thread(()->{

            try {
                //等待latch2倒计时结束，为0则往下执行
                latch2.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("3执行");
        }).start();
    }

    //使用CyclicBarrier让线程依次执行
    private static void CyclicBarrier(){
        CyclicBarrier barrier1=new CyclicBarrier(2);

        CyclicBarrier barrier2=new CyclicBarrier(2);

        new Thread(()->{
            try {
                //第一次放开barrier1
                barrier1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("线程1执行");

        }).start();

        new Thread(()->{
            try {
                //第二次放开barrier1，此时1开始执行
                barrier1.await();
                System.out.println("线程2执行");
                //第一次放开barrier2
                barrier2.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                //第二次放开barrier2，此时2开始执行
                barrier2.await();
                //接着3执行
                System.out.println("线程3执行");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
