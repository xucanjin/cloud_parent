package com.xu.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author xucanjin
 * @date 2022/03/20
 * @description
 */
public class ParseExcel {
    public static void main(String[] args) throws InterruptedException {

        //几万条excel数据批量导入，身份证已存在的不解析
        List<String> dataList = new ArrayList<>();
        dataList.add("1");
        dataList.add("2");
        //读取excel。填充dataList,代码略

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        //创建CountDownLatch
        CountDownLatch latch = new CountDownLatch(dataList.size());
        for (String s : dataList) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        //去数据表校验，身份证不重复的才插入数据

                    }catch (Exception e){
                        e.printStackTrace();
                    }finally {
                        latch.countDown();
                    }
                }
            });
        }
        //给一个最大超时时间，防止出现一些想不到的情况
        latch.await(30000, TimeUnit.MILLISECONDS);
        //
    }
}
