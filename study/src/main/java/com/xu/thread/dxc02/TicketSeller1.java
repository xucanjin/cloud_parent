package com.xu.thread.dxc02;

import java.util.Vector;
import java.util.concurrent.TimeUnit;

/**
 * @Author: canjin
 * @Date: 2021/6/24
 * 说明:
 */
public class TicketSeller1 {

    static Vector<String> tickets=new Vector<>();

    static {
        for(int i=0;i<1000;i++){
            tickets.add("编号"+i);
        }
    }

    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            new Thread(()->{
                //线程不安全，有可能出现数组越界，超卖现象出现
                while(tickets.size()>0){

                    try {
                        TimeUnit.MILLISECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("销售了--"+tickets.remove(0));
                }
            }).start();
        }
    }
}
