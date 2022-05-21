package com.xu.algorithm.dp;

/**
 * @author xucanjin
 * @date 2022/05/08
 * @description 爬楼梯
 */
public class ClimbStair {

    public static void main(String[] args) {

        for (int i = 1; i < 15; i++) {
            System.out.println(get(i));
        }
    }

    public static int get(int n) {

        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
