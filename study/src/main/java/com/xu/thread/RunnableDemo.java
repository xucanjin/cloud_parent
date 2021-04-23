package com.xu.thread;

/**
 * @Author: canjin
 * @Date: 2021/3/5
 * 说明: 两个线程交替打印1到100
 */
public class RunnableDemo implements Runnable{

    //1、重写run()方法，将输出1到100之间整数的代码写到同步方法里。
    //2、线程1进入到同步方法，输出一个整数后，阻塞并释放锁。
    //3、线程2进入到同步方法，唤醒线程1，输出整数后，阻塞并释放锁。
    //4、线程1和线程2重复第3步，直到输出所有的整数。

    private  int num=1;
    @Override
    public void run() {
        while (true){
            synchronized (this){
                notify();//就会唤醒被wait的一个线程，如果有多个线程被wait，就唤醒优先级高的那个。
                if(num<=100){
                    System.out.println(Thread.currentThread().getName()+":"+num);
                    num++;

                    try {
                        wait();//阻塞并释放锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    break;
                }
            }
        }
    }
}

class Main{
    public static void main(String[] args) {
        RunnableDemo demo=new RunnableDemo();
        Thread t1=new Thread(demo);
        Thread t2=new Thread(demo);
        t1.start();
        t2.start();
    }
}
