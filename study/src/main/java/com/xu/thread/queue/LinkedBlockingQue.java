package com.xu.thread.queue;

import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Author: canjin
 * @Date: 2021/6/30
 * 说明: put方法：元素满了会阻塞  ，take方法：空了会阻塞
 */
public class LinkedBlockingQue {

    static BlockingDeque<String> blockingDeque=new LinkedBlockingDeque<>();

    public static void main(String[] args) {
        Random r=new Random();
        new Thread(()->{
            for(int i=0;i<100;i++){
                try {
                    //如果满了，就会等待
                    blockingDeque.put("a"+i);
                    Thread.sleep(r.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"p1").start();

        for(int i=0;i<5;i++){
            new Thread(()->{
                for(;;){
                    try {
                        System.out.println(Thread.currentThread().getName()+"--"+blockingDeque.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },"consumer"+i).start();
        }
    }
}
