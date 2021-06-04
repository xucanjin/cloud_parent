package com.xu.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: canjin
 * @Date: 2021/4/7
 * 说明:
 */
public class ListTest {
    public static void main(String[] args) {
        //listTest1();
        //test2();
        sort();
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

    private static void sort(){
        List<String> names = Arrays.asList("peterF", "anna", "mike", "xenia","33");
        Stream<String> stream = names.stream().filter(s -> s.equals("anna"));
        //将stream变为list
        List<String> list = stream.collect(Collectors.toList());

        List<String> list2=new ArrayList<>();
        names.stream().forEach(name->{
            if(!name.equals("mike")){
                list2.add(name);
            }
        });
        System.out.println(list2.toString());
    }
}
