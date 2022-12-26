package com.xu.algorithm.linkedlist;

import java.util.Arrays;

/**
 * @author xucanjin
 * @date 2022/04/12
 * @description 动态规划
 */
public class DPTest {

    //public int coinChange(int【】 coins, int amount) {
    //
    //        if(amount == 0)return 0;
    //
    //        int【】 dp = new int【amount+1】;
    //        Arrays.fill(dp, Integer.MAX_VALUE);
    //        dp【0】 = 0;
    //
    //        for(int coin: coins) {
    //            for(int i=coin;i<=amount;i++) {
    //                if(dp【i-coin】 != Integer.MAX_VALUE) {
    //                    dp【i】 = Math.min(dp【i】, dp【i-coin】+1);
    //                }
    //            }
    //        }
    //
    //        return dp【amount】 == Integer.MAX_VALUE ? -1 : dp【amount】;
    //    }
    //}


    public static int change(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount];

        //将dp数组中每个元素的值都设为Integer.MAX_VALUE
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        int i = lengthOfList(nums);

        findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7});

    }


    /**
     * 最长递增子序列的长度
     * int[] nums = new int[]{10,9,2,5,3,7,101,18};
     * 输出：4
     * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4
     */
    private static int lengthOfList(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        // dp[i]表示i之前包括i的以nums[i]结尾的最长递增子序列的长度
        int[] dp = new int[nums.length];
        // 初始化条件 dp[i]长度至少都是1
        // 将dp数组的每个值都初始化为1
        Arrays.fill(dp, 1);

        int result = 0;
        for (int i = 1; i < nums.length; i++) {

            //位置i的最长递增子序列等于j从0到i-1各个位置的最长递增子序列 + 1 的最大值。
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (result < dp[i]) {
                result = dp[i];
            }
        }
        System.out.println(result);
        return result;
    }


    /**
     * 最长重复子数组
     *
     * A: [1,2,3,2,1]
     * B: [3,2,1,4,7]
     * 输出长度：3
     * 解释：长度最长的公共子数组是 [3, 2, 1]
     */
    private static int findLength(int[] nums1,int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return 0;
        }
        // dp[i][j] ：以下标i - 1为结尾的A，和以下标j - 1为结尾的B，最长重复子数组长度为dp[i][j]
        // 数组默认值都是0，无需专门初始化
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];

        // 记录长度
        int result = 0;

        //确定递推公式
        //根据dp[i][j]的定义，dp[i][j]的状态只能由dp[i - 1][j - 1]推导出来。
        //即当A[i - 1] 和B[j - 1]相等的时候，dp[i][j] = dp[i - 1][j - 1] + 1;
        //根据递推公式可以看出，遍历i 和 j 要从1开始！

        // 记录打印元素，builder可以不要
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    builder.append(nums1[i-1]).append(",");
                }
                if (result < dp[i][j]) {
                    result = dp[i][j];
                }
            }
        }
        System.out.println("长度："+result);
        System.out.println(builder.toString());
        return result;
    }
}
