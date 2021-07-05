package com.xu.thread.dxc02;

import java.util.LinkedList;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

/**
 * @Author: canjin
 * @Date: 2021/6/24
 * 说明:
 */
public class TicketSeller2 {

    static LinkedList<String> tickets=new LinkedList<>();

    static {
        for(int i=0;i<1000;i++){
            tickets.add("编号"+i);
        }
    }

    public static void main(String[] args) {
        for(int i=0;i<10;i++){
             new Thread(()->{

                 //使用synchronized加锁，保证线程安全，销售是按顺序的
                 while(true){
                     synchronized (tickets){
                         if(tickets.size()<=0){
                             break;
                         }
                         try {
                             TimeUnit.MILLISECONDS.sleep(10);
                         } catch (InterruptedException e) {
                             e.printStackTrace();
                         }
                         System.out.println("销售了--"+tickets.remove(0));

                     }
                 }
             }).start();
        }
    }
}
