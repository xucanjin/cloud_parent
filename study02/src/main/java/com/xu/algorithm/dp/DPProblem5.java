package com.xu.algorithm.dp;

/**
 * @author xucanjin
 * @date 2023/01/04
 * @description 买卖股票
 */
public class DPProblem5 {
    public static void main(String[] args) {

        maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        maxProfit2(new int[]{7, 1, 5, 3, 6, 4});

        maxProfit3(new int[]{3, 3, 5, 0, 0, 3, 1, 4});

        maxProfit4(new int[]{2, 4, 1}, 2);
        //maxProfit4(new int[]{3, 2, 6, 5, 0, 3}, 2);

        maxProfit5(new int[]{1, 2, 3, 0, 2});
    }

    /**
     * 买卖股票的最佳时机
     * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
     * <p>
     * 输入：[7,1,5,3,6,4]
     * 输出：5  6-1=5
     */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // dp[i][0]代表第i天持有股票的最大收益
        // dp[i][1]代表第i天不持有股票的最大收益
        int[][] dp = new int[prices.length][2];

        // 初始化
        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], 0 - prices[i]);
            // 第i天卖出股票，所得现金就是按照今天股票佳价格卖出后所得现金即：dp[i - 1][0] + prices[i]
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        int max = Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
        System.out.println("maxProfit1:" + max);
        return max;
    }

    /**
     * 买卖股票2
     * 股票可以买卖多次
     * 输入: [7,1,5,3,6,4]
     * 输出: 7
     */
    public static int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // dp[i][0]代表第i天持有股票的最大收益
        // dp[i][1]代表第i天不持有股票的最大收益
        int[][] dp = new int[prices.length][2];

        // 初始化
        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            // 第i天卖出股票，所得现金就是按照今天股票佳价格卖出后所得现金即：dp[i - 1][0] + prices[i]
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        int max = Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
        System.out.println("maxProfit2:" + max);
        return max;
    }

    /**
     * 买卖股票3
     * 股票可以最多可以买卖2次
     * <p>
     * 输入：prices = [3,3,5,0,0,3,1,4] 输出：6
     * 解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，
     * 这笔交易所能获得利润 3。在第 7 天（股票价格 = 1）的时候买入，
     * 在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润3。
     */
    public static int maxProfit3(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int length = prices.length;
        //一天一共就有五个状态，
        //0 没有操作
        //1 第一次持有股票
        //2 第一次不持有股票
        //3 第二次持有股票
        //4 第二次不持有股票
        int[][] dp = new int[length][5];

        // 没有操作
        dp[0][0] = 0;
        // 第一次持有股票
        dp[0][1] = 0 - prices[0];
        // 第一次不持有股票
        dp[0][2] = 0;
        // 第二次持有股票
        dp[0][3] = 0 - prices[0];
        dp[0][4] = 0;

        for (int i = 1; i < length; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], 0 - prices[i]);
            // 操作一：第i天卖出股票了，那么dp[i][2] = dp[i - 1][1] + prices[i]
            // 操作二：第i天没有操作，沿用前一天卖出股票的状态，即：dp[i][2] = dp[i - 1][2]
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);

            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        int max = Math.max(dp[length - 1][2], dp[length - 1][4]);
        System.out.println("maxProfit3:" + max);
        return max;
    }

    /**
     * 买卖股票4
     * 你最多可以完成k笔交易； 买入和卖出各算一次交易
     * <p>
     * 输入：k = 2, prices = [2,4,1] 输出：2
     * 输入：k = 2, prices = [3,2,6,5,0,3]
     */
    public static int maxProfit4(int[] prices, int k) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;

        int[][] dp = new int[len][k * 2 + 1];

        dp[0][0] = 0;

        // 初始化 除0以外，偶数就是卖出，奇数就是买入
        for (int i = 1; i < 2 * k; i += 2) {
            dp[0][i] = 0 - prices[0];
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < 2 * k; j += 2) {
                // dp[i - 1][j] 不持有
                // 持有股票
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i]);
                // dp[i - 1][j + 1] 持有
                // 不持有股票
                dp[i][j + 2] = Math.max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i]);
            }
        }
        int i = dp[len - 1][2 * k];
        System.out.println("maxProfit4:" + i);
        return i;
    }

    /**
     * 最佳买卖股票时机5
     * <p>
     * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
     * 输入: [1,2,3,0,2]
     * 输出: 3
     * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出
     */
    public static int maxProfit5(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // 0 状态一：持有股票状态（今天买入股票，或者是之前就买入了股票然后没有操作，一直持有）
        // 不持有股票状态，这里就有两种卖出股票状态
        // 1 状态二：保持卖出股票的状态（两天前就卖出了股票，度过一天冷冻期。或者是前一天就是卖出股票状态，一直没操作）
        // 2 状态三：今天卖出股票
        // 3 状态四：今天为冷冻期状态，但冷冻期状态不可持续，只有一天！

        int[][] dp = new int[prices.length][4];

        // 持有股票
        dp[0][0] = -prices[0];
        // 保持卖出股票的状态
        dp[0][1] = 0;
        // 今天卖出股票
        dp[0][2] = 0;
        // 冷冻期状态
        dp[0][3] = 0;

        for (int i = 1; i < prices.length; i++) {
            // 操作一：前一天就是持有股票状态（状态一），dp[i][0] = dp[i - 1][0]
            //操作二：今天买入了，有两种情况
            //前一天是冷冻期（状态四），dp[i - 1][3] - prices[i]
            //前一天是保持卖出股票的状态（状态二），dp[i - 1][1] - prices[i]
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][3] - prices[i], dp[i - 1][1] - prices[i]));
            // 操作一：前一天就是状态二
            //操作二：前一天是冷冻期（状态四）
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);

            dp[i][2] = dp[i - 1][0] + prices[i];
            // 达到冷冻期状态（状态四）一定是昨天卖出了股票（状态三）
            dp[i][3] = dp[i - 1][2];
        }
        int len = prices.length - 1;
        int max = Math.max(dp[len][1], Math.max(dp[len][2], dp[len][3]));
        System.out.println("maxProfit5:" + max);
        return max;
    }
}
