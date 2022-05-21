package com.xu.algorithm.arraylist;

import cn.hutool.core.collection.ListUtil;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author xucanjin
 * @date 2022/05/10
 * @description
 */
public class StackTest {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);

        Integer pop = stack.pop();
        System.out.println(pop);

        List<String> list = ListUtil.of("1231", "1213");
        List<String> collect = list.stream().filter(s -> s.length() > 1).collect(Collectors.toList());
    }
}
