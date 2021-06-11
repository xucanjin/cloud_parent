package com.xu.thread;

import java.util.concurrent.CompletableFuture;

/**
 * @Author: canjin
 * @Date: 2021/6/10
 * 说明: A和B并行执行
 *      C会等待A和B结束后执行。
 */
public class CompleTableTest2 {

    public static void main(String[] args) {

        //带返回值的异步方法
        CompletableFuture completableA=CompletableFuture.supplyAsync(()->{
            return "23";
        });

        CompletableFuture completableB=CompletableFuture.supplyAsync(()->{
            return "67";
        });

        //C会等待A和B结束后执行 thenCombine 合并任务
        CompletableFuture C=completableA.thenCombine(completableB,(rs1,rs2)->{
            return rs1+"-"+rs2;
        });

        //得到C的结果
        System.out.println(C.join());
    }
}
