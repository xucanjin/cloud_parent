package com.xu.test.design.builder;

/**
 * @Author: canjin
 * @Date: 2021/4/10
 * 说明:
 */
public class StringBuildTest {
    public static void main(String[] args) {
        StringBuild build=new StringBuild();
        String s = build.append("11").append("22").build();
        System.out.println(s);
    }
}
