package com.xu.thread.dxc02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author: canjin
 * @Date: 2021/6/24
 * 说明: ConcurrentLinkedQueue  队列效率是最高的
 */
public class TicketSeller3 {

    static Queue<String> tickets=new ConcurrentLinkedQueue<>();

    static {
        for(int i=0;i<1000;i++){
            tickets.add("编号"+i);
        }
    }

    public static void main(String[] args) {
        for(int i=0;i<10;i++){
             new Thread(()->{

                 while(true){
                     //从队列中拿数据
                     String poll = tickets.poll();
                     if(poll==null){
                         break;
                     }
                     System.out.println("销售了--"+poll);
                 }
             }).start();
        }
    }
}
