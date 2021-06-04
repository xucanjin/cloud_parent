package com.xu.thread.dxc01;

import java.util.LinkedList;

/**
 * @Author: canjin
 * @Date: 2021/6/2
 * 说明:写一个固定容量的容器，有put和get方法，及getCount方法，能够支持2个生产者线程和10个消费者线程的阻塞调用

 */
public class MyContainer<T> {

    final private LinkedList<T> lists=new LinkedList<>();
    final private int Max=10;
    private int count=0;

    public synchronized void put(T t){
        while(lists.size()==Max){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lists.add(t);
        count++;
        System.out.println("计数："+count);
        //通知消费者
        this.notifyAll();
    }

    public synchronized T get(){
        T t=null;
        while(lists.size()==0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        t = lists.removeFirst();
        count--;
        this.notifyAll();
        return t;
    }

    public static void main(String[] args) {
        MyContainer<String> c=new MyContainer<>();

        //消费者
        for(int i=0;i<10;i++){
            new Thread(()->{
                System.out.println(c.get());
            },"c"+i).start();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //生产者线程
        for(int i=0;i<2;i++){
            new Thread(()->{
                for(int j=0;j<10;j++){
                    c.put(Thread.currentThread().getName()+" "+j);
                }
            },"p"+i).start();
        }
    }
}
