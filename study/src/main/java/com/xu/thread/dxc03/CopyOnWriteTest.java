package com.xu.thread.dxc03;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: canjin
 * @Date: 2021/6/30
 * 说明:
 */
public class CopyOnWriteTest {

    private static List<String> list=new CopyOnWriteArrayList<>();
    public static void main(String[] args) {

        Random r=new Random();
        Thread[] th=new Thread[100];

        for(int i=0;i<th.length;i++){
            Runnable task=new Runnable() {
                @Override
                public void run() {
                    for(int i=0;i<1000;i++){
                        list.add("a"+r.nextInt(10000));
                    }
                }
            };
            th[i]=new Thread(task);
        }
        runAndCompute(th);
        System.out.println(list.size());
    }

    static void runAndCompute(Thread[] th){
        long s1 = System.currentTimeMillis();
        Arrays.asList(th).forEach(t->t.start());
        Arrays.asList(th).forEach(t->{
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long s2 = System.currentTimeMillis();
        System.out.println(s2-s1);
    }
}
