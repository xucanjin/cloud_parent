package com.xu.algorithm.linkedlist;

/**
 * @author xucanjin
 * @date 2022/04/21
 * @description
 */
public class DiguiTest {
    public static void main(String[] args) {
        //每个数的值是前2个数的和

        System.out.println(func(3));
        System.out.println(func(4));
        System.out.println(func(5));

    }

    private static int func(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int prev = 0;
        int curr = 1;
        for (int i = 2; i <= n; i++) {
            int sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        return curr;
    }
}
