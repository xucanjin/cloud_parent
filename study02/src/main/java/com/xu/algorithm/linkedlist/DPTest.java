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

    }
}
