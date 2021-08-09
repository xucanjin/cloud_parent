package com.xu.test.blbl;

/**
 * @Author: canjin
 * @Date: 2021/8/6
 * 说明:
 */
public class StrDemo2 {
    public static void main(String[] args) {
        //abc是在常量池中 ，String会放到堆中
        String s1=new String("abc");
        //会先看常量池中有没有，如果没有会创建一个新的
        String s2="abc";
        System.out.println(s1==s2);//false

        //String的intern()方法首先会看字符串常量池中是否存在"abc"，如果存在则返回该字符串引用，
        // 如果不存在则把abc添加到字符串常量池中，并返回该字符串引用
        String s3=s1.intern();
        System.out.println(s3==s2);//true
    }
}
