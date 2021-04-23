package com.xu.test.design.builder;

/**
 * @Author: canjin
 * @Date: 2021/4/8
 * 说明:
 */
public class Test {
    public static void main(String[] args) {
        Course build1 = new Builder().addName("java").addVideo("视频1").build();
        Course build2 = new Builder().addName("PHP").addPPt("ppt").build();
        System.out.println(build1.toString());

        System.out.println(build2.toString());
    }
}
