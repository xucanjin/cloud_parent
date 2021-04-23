package com.xu.test;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;

/**
 * @Author: canjin
 * @Date: 2021/2/19
 * 说明:
 */
public class StringTest {

    public static void main(String[] args) {
        sdd();
        inte();
    }

    public static void sdd(){
        String s1="hello";
        String s2="he"+new String("llo");
        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));

    }

    public static void subs(String str){
        String ss="12455:id";
        String s2=ss.substring(0,str.length()-4);
        System.out.println(ss);
        Thread thread = new Thread();
        System.out.println(s2);
    }

    public static void inte(){
        int i=120;
        int x=120;
        Integer a=129;
        Integer b=129;
        System.out.println(i==x);
        System.out.println(a.equals(b));
    }
}
