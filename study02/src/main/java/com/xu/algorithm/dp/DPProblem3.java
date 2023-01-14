package com.xu.algorithm.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author xucanjin
 * @date 2022/12/30
 * @description 完全背包相关题目
 */
public class DPProblem3 {

    public static void main(String[] args) {

        //change(5,new int[]{1, 2, 5});

        coinChange(new int[]{1, 2, 5},11);
        //numSquares(12);

        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        wordBreak("leetcode",list);
    }

    /**
     * 零钱兑换 II
     * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。
     * 假设每一种面额的硬币有无限个。
     *
     * 示例 1:
     * 输入: amount = 5, coins = [1, 2, 5]
     * 输出: 4
     *
     * 5=5
     * 5=2+2+1
     * 5=2+1+1+1
     * 5=1+1+1+1+1
     */
    public static int change(int amount, int[] coins) {
        // dp[j]：凑成总金额j的货币组合数
        int[] dp = new int[amount + 1];

        // 首先dp[0]一定要为1，dp[0] = 1是 递归公式的基础。如果dp[0]=0的话，后面所有推导出来的值都是0了。
        dp[0] = 1;


        // 先遍历物品
        for (int i = 0; i < coins.length; i++) {
            // 完全背包要从小到大遍历
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }

        // 先遍历物品再遍历背包求得是组合数，不强调元素的顺序
        // 先遍历背包再遍历物品求得是排列数，强调元素的顺序
        System.out.println(dp[amount]);
        return dp[amount];
    }

    /**
     * 零钱兑换
     *
     * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
     * 你可以认为每种硬币的数量是无限的。
     * 示例 1： 输入：coins = [1, 2, 5], amount = 11 输出：3 解释：11 = 5 + 5 + 1
     * 示例 2： 输入：coins = [2], amount = 3 输出：-1
     * 示例 3： 输入：coins = [1], amount = 0 输出：0
     */
    public static int coinChange(int[] coins, int amount) {
        int max = Integer.MAX_VALUE;

        // dp[j]：凑足总额为j所需钱币的最少个数为dp[j]
        int[] dp = new int[amount + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i] = max;
        }
        //当金额为0时需要的硬币数目为0，其他给Integer的最大值
        dp[0] = 0;

        // 求的是最少的个数，所以使用min
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                //只有dp[j-coins[i]]不是初始最大值时，该位才有选择的必要
                if (dp[j - coins[i]] != max) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        int result = dp[amount] == max ? -1 : dp[amount];
        System.out.println(result);
        return result;
    }

    /**
     * 完全平方数

     * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。
     * 你需要让组成和的完全平方数的个数最少。
     * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
     * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
     *
     * 示例 1： 输入：n = 12 输出：3 解释：12 = 4 + 4 + 4
     * 示例 2： 输入：n = 13 输出：2 解释：13 = 4 + 9
     */
    public static int numSquares(int n) {
        int max = Integer.MAX_VALUE;
        // dp[j]：和为j的完全平方数的最少数量
        int[] dp = new int[n + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = max;
        }
        //当和为0时，组合的个数为0
        dp[0] = 0;

        // 完全平方数可以用 i*i 表示
        for (int i = 1; i * i <= n; i++) {
            for (int j = i * i; j <= n; j++) {
                if (dp[j - i * i] != max) {
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                }
            }
        }
        // 打印dp数组
        for (int i = 1 ; i * i <= n; i++) {
            for (int j = i * i; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                System.out.print(dp[j]+"\t");
            }
            System.out.println();
        }
        System.out.println(dp[n]);
        return dp[n];
    }

    /**
     * 单词拆分
     *
     * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
     * 说明：
     * 拆分时可以重复使用字典中的单词。
     *
     * 示例 1：
     * 输入: s = "leetcode", wordDict = ["leet", "code"]
     * 输出: true
     * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
     *
     * s 背包 wordDict 物品
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);

        // 字符串长度为i的话，dp[i]为true，表示可以拆分为一个或多个在字典中出现的单词
        boolean[] dp = new boolean[s.length()+1];

        dp[0] = true;

        // 先遍历背包
        for (int i = 1; i < s.length()+1; i++) {
            for (int j = 0; j < i && !dp[i]; j++) {
                // i>j ,如果确定dp[j] 是true，且 [j, i] 这个区间的子串出现在字典里，那么dp[i]一定是true
                if (set.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                }
            }
        }
        System.out.println(dp[s.length()]);
        return dp[s.length()];
    }

}
