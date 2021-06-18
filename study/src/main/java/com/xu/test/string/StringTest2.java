package com.xu.test.string;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @Author: canjin
 * @Date: 2021/4/18
 * 说明:
 */
public class StringTest2 {
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        //sortByString("asffdadwr");
        test3();
    }


    public static void sortByString(String s){
        char[] chars = s.toCharArray();
        Map<Character,Integer> map=new TreeMap<>();
        for(Character ch:chars){
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }else{
                map.put(ch,1);
            }
        }
        map.forEach((k,v)-> System.out.print(k+""+v));
    }

    public static void test2(){
        String sql="select account_no,grade,to_char(next_review_date,'yyyyMMdd') next_review_date," +
        "is_associate_pep,status,to_char(current_rdate,'yyyyMMdd') current_rdate,pep_type from";
        int count = sql.substring(0, sql.toLowerCase().indexOf("from")).split(",").length;

        System.out.println(count);
    }

    //去掉字符串的空格
    public static void test3(){
        String s="abc def   ";
        String replace = s.replace(" ", "");
        System.out.println(replace+" length:"+replace.length());
    }
}
