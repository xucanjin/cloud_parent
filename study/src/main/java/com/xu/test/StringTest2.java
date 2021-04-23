package com.xu.test;

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
        sortByString("asffdadwr");
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
}
