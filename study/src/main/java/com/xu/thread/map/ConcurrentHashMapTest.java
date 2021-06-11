package com.xu.thread.map;

import com.xu.util.Constants;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: canjin
 * @Date: 2021/6/4
 * 说明:
 */
public class ConcurrentHashMapTest {
    static Map<UUID,UUID> m=new ConcurrentHashMap<>();
    static int count= Constants.COUNT;
    static UUID[] keys=new UUID[count];
    static UUID[] values=new UUID[count];
    static final int thread_count=1000;

    static{
        for(int i=0;i<count;i++){
            keys[i]=UUID.randomUUID();
            values[i]=UUID.randomUUID();
        }
    }

    static class MyThread extends Thread{
        int start;
        int gap=count/thread_count;

        public MyThread(int start) {
            this.start = start;
        }

        @Override
        public void run() {
            for(int i=start;i<start+gap;i++){
                m.put(keys[i],values[i]);
            }
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Thread[] threads=new Thread[thread_count];
        for(int i=0;i<threads.length;i++){
            threads[i]=new MyThread(i*(count/thread_count));
        }

        for(Thread t:threads){
            t.start();
        }

        for(Thread t:threads){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();

        System.out.println(end-start);
        System.out.println(m.size());
    }
}
