package com.xu.algorithm.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author xucanjin
 * @date 2023/03/08
 * @description
 */
public class Problem1 {
    public static void main(String[] args) {
        problem();
    }

    /**
     * 10个人围成一个圆圈，从序号1开始为这些人依次编号。
     * 第一个人从数字1开始报数，数到3的人则离开该圆圈
     */
    public static void problem() {
        ArrayList list = new ArrayList();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
        int index = 1;
        while (list.size() > 1) {
            if (index == 3) {
                list.remove(0);
                index = 1;
            } else {
                list.add(list.remove(0));
                index++;
            }
        }
        System.out.println(list.get(0));
    }

}
