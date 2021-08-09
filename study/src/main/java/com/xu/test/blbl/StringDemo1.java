package com.xu.test.blbl;

import java.lang.reflect.Field;

/**
 * @Author: canjin
 * @Date: 2021/8/6
 * 说明:
 */
public class StringDemo1 {
    public static void main(String[] args) {
        String s=new String("abc");
        //如何保证s引用的指向不变，最终将输出变成abcd

        //反射
        try {
            Field value = s.getClass().getDeclaredField("value");
            value.setAccessible(true);
            value.set(s,"abcd".toCharArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(s);
    }
}
