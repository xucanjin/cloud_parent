package com.xu.thread;

import java.util.Date;

/**
 * @Author: canjin
 * @Date: 2021/3/5
 * 说明:
 */
public class MyRunnable implements Runnable{

    private String commond;

    public MyRunnable(String s) {
       this.commond=s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"Start.Time =" +new Date());
        process();
        System.out.println("End.time="+new Date());
    }

    private void process(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
