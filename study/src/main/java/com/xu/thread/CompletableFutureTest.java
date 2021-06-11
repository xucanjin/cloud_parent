package com.xu.thread;

import java.util.concurrent.CompletableFuture;

/**
 * @Author: canjin
 * @Date: 2021/6/10
 * 说明:
 */
public class CompletableFutureTest {
    public static void main(String[] args) throws Exception{

        //runAsync 没有返回值的方法
        CompletableFuture completableFuture=CompletableFuture.runAsync(()->{
            System.out.println("hello");
        });

        // 创建异步执行任务  supplyAsync：带返回值的方法
        CompletableFuture<String> cf1=CompletableFuture.supplyAsync(()->{
            return query("中国");
        });
        //thenApplyAsync 方法:把两个线程串行化
        CompletableFuture<Double> cf2=cf1.thenApplyAsync((code)->{
            return getPrice(code);
        });
        cf2.thenAccept(rs->{
            System.out.println("price:"+rs);
        });

        //handle 方法和 thenApply 方法处理方式基本一样。不同的是 handle是在任务完成后再执行，还可以处理异常的任务。
        // thenApply 如果任务出现异常则不执行
        CompletableFuture<String> com=CompletableFuture.supplyAsync(()->{
            return "123";
        });


        //主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        Thread.sleep(500);
        System.out.println("20000");
    }

    static String query(String name){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(name.equals("")){
            return "66666";
        }
        return "77777";
    }

    static Double getPrice(String code) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(code.equals("66666")){
            return Double.valueOf(10);
        }
        return 10 + Math.random() * 100;
    }
}
