package com.xu.MyTong;

import com.google.common.util.concurrent.RateLimiter;

/**
 * @Author: canjin
 * @Date: 2021/2/4
 * 说明:
 */

public class MyTong1 {

    public void test1(){
        RateLimiter rateLimiter=RateLimiter.create(5);
        boolean acquire = rateLimiter.tryAcquire();

        if(acquire){
            System.out.println("");
        }
    }
}
