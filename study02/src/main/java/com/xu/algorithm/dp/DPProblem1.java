package com.xu.algorithm.dp;

/**
 * @author xucanjin
 * @date 2022/12/27
 * @description
 */
public class DPProblem1 {

    public static void main(String[] args) {

        minCostClimbingStairs(new int[]{10, 15, 20});
        //minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1});

        //uniquePaths(3,7);

        //integerBreak(10);
        //integerBreak(6);

        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        // 最大容量
        int bagSize = 4;
        testWeightBagProblem(weight, value, bagSize);
    }

    /**
     * 使用最小花费爬楼梯
     * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。
     * 一旦你支付此费用，即可选择向上爬一个或者两个台阶。
     * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。请你计算并返回达到楼梯顶部的最低花费。
     *
     * 输入：cost = [10, 15, 20]
     * 输出：15
     * 解释：最低花费是从 cost[1] 开始，然后走两步即可到阶梯顶，一共花费 15
     */
    private static int minCostClimbingStairs(int[] nums) {

        // dp数组：到达第i台阶所花费的最少体力为dp[i]
        int[] dp = new int[nums.length + 1];
        // 从0或者1开始默认不需要花费体力，往上跳时才需要花费体力
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.min(dp[i - 1] + nums[i - 1], dp[i - 2] + nums[i - 2]);
        }
        System.out.println(dp[nums.length]);
        return dp[nums.length];
    }

    /**
     * 不同路径
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
     * 问总共有多少条不同的路径？
     * 输入：m = 3, n = 7
     * 输出：28
     *
     * 输入：m = 2, n = 3
     * 输出：3
     */
    private static int uniquePaths(int m, int n) {

        // dp[i][j] ：表示从（0 ，0）出发，到(i, j)有多少条不同的路径。
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        //想要求dp[i][j]，只能有两个方向来推导出来，即dp[i - 1][j] 和 dp[i][j - 1]。
        //此时在回顾一下 dp[i - 1][j] 表示啥，是从(0, 0)的位置到(i - 1, j)有几条路径，dp[i][j - 1]同理。
        //那么很自然，dp[i][j] = dp[i - 1][j] + dp[i][j - 1]，因为dp[i][j]只有这两个方向过来。
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        System.out.println(dp[m - 1][n - 1]);
        return dp[m - 1][n - 1];
    }

    /**
     * 整数拆分
     * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。
     * 返回你可以获得的最大乘积。
     * 输入: 2
     * 输出: 1
     * 解释: 2 = 1 + 1, 1 × 1 = 1。
     *
     * 输入: 10
     * 输出: 36
     * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
     */
    private static int integerBreak(int n) {
        // dp[i]：分拆数字i，可以得到的最大乘积为dp[i]。
        int[] dp = new int[n + 1];

        // 拆分 0和1是无意义的
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;

        // 其实可以从1遍历j，然后有两种渠道得到dp[i].
        //一个是j * (i - j) 直接相乘。
        //一个是j * dp[i - j]，相当于是拆分(i - j)，
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        System.out.println(dp[n]);
        return dp[n];
    }

    /**
     * 01背包
     * 有n件物品和一个最多能背重量为w 的背包。
     * 第i件物品的重量是weight[i]，得到的价值是value[i] 。每件物品只能用一次，求解将哪些物品装入背包里物品价值总和最大。
     *      重量	价值
     * 物品0	 1	15
     * 物品1	 3	20
     * 物品2	 4	30
     *
     * @param weight  物品的重量
     * @param value   物品的价值
     * @param bagSize 背包的容量
     */
    private static void testWeightBagProblem(int[] weight, int[] value, int bagSize) {

        // dp[i][j] 表示从下标为[0-i]的物品里任意取，放进容量为j的背包，价值总和最大是多少。
        int goods = weight.length;
        int[][] dp = new int[goods][bagSize + 1];

        // 初始化dp数组
        // 创建数组后，其中默认的值就是0
        for (int j = weight[0]; j <= bagSize; j++) {
            dp[0][j] = value[0];
        }

        // 因为0已经初始化过了，所以从1开始
        for (int i = 1; i < weight.length; i++) {
            for (int j = 1; j <= bagSize; j++) {
                /**
                 * 当前背包的容量都没有当前物品i大的时候，是不放物品i的
                 * 那么前i-1个物品能放下的最大价值就是当前情况的最大价值
                 */
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    /**
                     * 当前背包的容量可以放下物品i
                     * 那么此时分两种情况：
                     *    1、不放物品i
                     *    2、放物品i
                     * 比较这两种情况下，哪种背包中物品的最大价值最大
                     */
                    //dp[i - 1][j - weight[i]] 为背包容量为j - weight[i]的时候不放物品i的最大价值，
                    // 那么dp[i - 1][j - weight[i]] + value[i] （物品i的价值），就是背包放物品i得到的最大价值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }

        // 打印dp数组
        for (int i = 0; i < goods; i++) {
            for (int j = 0; j <= bagSize; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println("\n");
        }

        System.out.println(dp[goods-1][bagSize]);
    }
}
