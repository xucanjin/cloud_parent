package com.xu.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: canjin
 * @Date: 2021/4/7
 * 说明:
 */
public class ListTest {
    public static void main(String[] args) {
        listTest1();
        test2();
    }

    public static void listTest1(){
        List<String> list=new ArrayList<>();
        list.add("china");
        list.add("hello");
        list.add("cafe");
        list.add("world");
        list.add("date");
        list.add("map");
        list.add("list");
        list.add("love");
        list.add("clear");

        //输出c开头的字符串,并按ASCII码表的大小进行排序
        list.stream().filter(item->item.startsWith("c")).sorted((s1,s2)->s1.compareTo(s2))
                .forEach(System.out::println);

        /*list.stream().filter(s->s.length()==1).forEach(s -> {
            System.out.println(s);
        });*/

        /*list.forEach(item->{
            System.out.println(item);
        });*/
    }

    public static String exc(){
        try{
            System.out.println("11111");
            return "22";
        }catch(Exception e){

        }finally{
            System.out.println("你好111");
        }
        return null;
    }

    public static void test2(){
       /* List<Object> list=new ArrayList<>();
        list.add("22");
        list.add("nihao1");

        String s = list.contains("22") ? "1" : "2";
        System.out.println(s);*/

        String[] arry={"1","2","3","4"};

        String collect = Arrays.stream(arry).collect(Collectors.joining());
        Arrays.stream(arry).collect(Collectors.toList());

    }
}
