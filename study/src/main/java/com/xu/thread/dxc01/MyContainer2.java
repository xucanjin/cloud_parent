package com.xu.thread.dxc01;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: canjin
 * @Date: 2021/6/2
 * 说明:写一个固定容量的容器，有put和get方法，及getCount方法，能够支持2个生产者线程和10个消费者线程的阻塞调用

 */
public class MyContainer2<T> {

    final private LinkedList<T> lists=new LinkedList<>();
    final private int Max=10;
    private int count=0;
    private Lock lock=new ReentrantLock();
    private Condition producer=lock.newCondition();
    private Condition consumer=lock.newCondition();

    public  void put(T t) {
        try {
            lock.lock();
            while (lists.size() == Max) {
                producer.await();
            }
            lists.add(t);
            ++count;
            System.out.println("11");
            //通知消费者线程
            consumer.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public T get() {
        T t = null;
        try {
            lock.lock();
            while (lists.size() == 0) {
                consumer.await();
            }
            t = lists.removeFirst();
            count--;
            //通知生产者线程
            producer.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return t;
    }

    public static void main(String[] args) {
        MyContainer2<String> c=new MyContainer2<>();

        //消费者
        for(int i=0;i<10;i++){
            new Thread(()->{
                for(int j=0;j<5;j++){
                    System.out.println(c.get());
                }
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
                for(int j=0;j<25;j++){
                    c.put(Thread.currentThread().getName()+" "+j);
                }
            },"p"+i).start();
        }
    }
}
