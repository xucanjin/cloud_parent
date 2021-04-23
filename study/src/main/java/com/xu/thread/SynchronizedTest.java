package com.xu.thread;

/**
 * @Author: canjin
 * @Date: 2021/4/9
 * 说明:
 */
public class SynchronizedTest {

    public static void main(String[] args) {

        new Thread(()->{
            test1();
        }).start();

        new Thread(()->{
            test2();
        }).start();
    }

    public static synchronized void test1(){
        System.out.println("111");
    }

    public static synchronized void test2(){
        System.out.println("222");
    }
}
