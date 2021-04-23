package com.xu.thread;

/**
 * @Author: canjin
 * @Date: 2021/3/5
 * 说明:
 */
public class ThreadTest1 implements Runnable{

    static int total=20;
    @Override
    public void run() {
        while(true){
            synchronized (this) {
                if (total > 0) {
                    total--;
                    System.out.println(Thread.currentThread().getName() + ":" + total);
                }else{
                    System.out.println("没了");
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Main2{
    public static void main(String[] args) {
        ThreadTest1 test=new ThreadTest1();
        //test.wait();
        new Thread(test).start();
        new Thread(test).start();
    }
}
