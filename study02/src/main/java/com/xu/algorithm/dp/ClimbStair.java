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

    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * 注意：给定 n 是一个正整数。
     *
     */
    public static int get(int n) {

        if (n <= 2) {
            return n;
        }
        // dp[i]： 爬到第i层楼梯，有dp[i]种方法
        // dp[1]:1个台阶的方法数，数组是从0开始的，要得到dp[n] 长度必须是n+1
        // n是正整数，不用考虑dp[0]这种情况
        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;

        // 直接从第3阶台阶开始
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
