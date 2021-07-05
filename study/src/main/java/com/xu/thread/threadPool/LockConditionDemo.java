package com.xu.thread.threadPool;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: canjin
 * @Date: 2021/7/1
 * 说明:  2个线程，一个输出1到26，另一个输出A到Z，让2个线程交替输出，顺序打印
 *       使用Lock和Condition实现
 */
public class LockConditionDemo {
    public static void main(String[] args) {

        Lock lock=new ReentrantLock();
        Condition condition = lock.newCondition();

        new Thread(()->{
            try{
                lock.lock();
                for(int i=1;i<=26;i++){
                    System.out.println(i);
                    //唤醒其他线程
                    condition.signal();
                    //阻塞自己
                    condition.await();
                }
                condition.signal();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        },"t1").start();


        new Thread(()->{
            try{
                lock.lock();
                for(char i = 'A'; i <= 'Z'; i++){
                    System.out.println(i);
                    //唤醒其他线程
                    condition.signal();
                    //阻塞自己
                    condition.await();
                }
                //唤醒被阻塞的线程，让程序正常结束
                condition.signal();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        },"t2").start();
    }
}
