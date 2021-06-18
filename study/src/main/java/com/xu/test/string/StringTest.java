package com.xu.test.string;


import com.alibaba.fastjson.JSONObject;

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
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: canjin
 * @Date: 2021/2/19
 * 说明:
 */
public class StringTest {

    public static void main(String[] args) {
        //sdd();
        //inte();
        //System.out.println(builder());
        //str2();
        //json();
        test2();
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

    private static String builder(){
        List<String> list=new ArrayList<>();
        list.add("120000");
        list.add("230000");
        list.add("340000");
        StringBuilder builder=new StringBuilder("(");
        list.stream().forEach(item->{
            builder.append("'"+item+"',");
        });
        builder.replace(builder.length()-1,builder.length(),")");
        return builder.toString();
    }
    private static void str2(){
       if("".equals(null)){
       }else{
           System.out.println("22");
       }
    }

    private static void json(){
        String ss="{a:1}";
        JSONObject object=JSONObject.parseObject(ss);
        System.out.println(object.toString());
    }

    private static void test2(){
        String no="8000030674.pdf";
        String trim =no.substring(no.lastIndexOf("."),no.length());
        System.out.println(trim+"11");
    }
}
