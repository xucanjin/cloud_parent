package com.xu.test;


import java.util.Arrays;
import java.util.List;

/**
 * @Author: canjin
 * @Date: 2021/2/19
 * 说明:
 */
public class LambdaTest {
    public static void main(String[] args) {

        new Thread(()-> System.out.println(Thread.currentThread().getName())).start();

        //遍历list并输出list中改的元素
        List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        features.forEach(System.out::println);

    }


}
