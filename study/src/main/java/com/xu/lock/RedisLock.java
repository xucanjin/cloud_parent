package com.xu.lock;


import java.util.concurrent.TimeUnit;

/**
 * @Author: canjin
 * @Date: 2021/3/12
 * 说明: redisson实现分布式锁
 */
public class RedisLock {

    public static void main(String[] args) {
        /*Config config = new Config();
        config.useSingleServer().setAddress("redis://47.110.92.234:6379");
        //config.useSingleServer().setUsername("");
        //config.useSingleServer().setPassword("");
        RedissonClient redisson = Redisson.create(config);

        RLock lock = redisson.getLock("lockName");

        for(int i=0;i<5;i++) {
            new Thread(()->{
                try {
                    // 1. 最常见的使用方法
                    //lock.lock();
                    // 2. 支持过期解锁功能,10秒钟以后自动解锁, 无需调用unlock方法手动解锁
                    //lock.lock(10, TimeUnit.SECONDS);

                    // 3. 尝试加锁，最多等待2秒，上锁以后8秒自动解锁
                    boolean res = lock.tryLock(2, 8, TimeUnit.SECONDS);
                    if (res) { //成功
                        //处理业务
                        System.out.println(Thread.currentThread().getName()+"获取锁成功");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //释放锁
                    lock.unlock();
                    System.out.println(Thread.currentThread().getName()+"释放锁");
                }
            }).start();
        }*/
    }
}
