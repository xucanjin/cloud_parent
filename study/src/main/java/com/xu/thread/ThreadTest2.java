package com.xu.thread;

/**
 * @Author: canjin
 * @Date: 2021/3/5
 * 说明:
 */
public class ThreadTest2 {
    public static void main(String[] args) {
        MyThread myThread=new MyThread();

        //子线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<50;i++) {
                    myThread.subThread(i);
                }
            }
        }).start();

        try {
            Thread.sleep(1000);//主线程让出CPU，让子线程先执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(int i=0;i<50;i++) {
            myThread.mainThread(i);
        }
    }
}

class MyThread{
    boolean running=true;//子线程方法是否被调用

    public synchronized void subThread(int i){
        if(!running){//主线程在运行
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int j=0;j<10;j++){
            System.out.println(Thread.currentThread().getName()+"子线程次数:"+j);
        }
        running=false;//子线程调用完毕
        this.notify();
    }

    public synchronized void mainThread(int i){
        if(running){//子线程在运行
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int j=0;j<50;j++){
            System.out.println(Thread.currentThread().getName()+"主线程次数:"+j);
        }
        running=true;////主线程调用完毕
        this.notify();
    }
}
