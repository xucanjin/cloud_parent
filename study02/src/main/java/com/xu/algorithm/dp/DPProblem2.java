package com.xu.algorithm.dp;

/**
 * @author xucanjin
 * @date 2022/12/28
 * @description 01背包相关题目
 */
public class DPProblem2 {

    public static void main(String[] args) {

        canPartition(new int[]{1, 5, 11, 5});
        lastStoneWeightII(new int[]{2, 3, 5, 1, 3, 3});
        //findTargetSumWays(new int[]{1,1,1,1,1},3);

        int m = 5, n = 3;
        findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, m, n);
    }

    /**
     * 分割等和子集
     * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
     * 示例 1: 输入: [1, 5, 11, 5] 输出: true 解释: 数组可以分割成 [1, 5, 5] 和 [11].
     * 示例 2: 输入: [1, 2, 3, 5] 输出: false 解释: 数组不能分割成两个元素和相等的子集.
     * @return
     */
    private static boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // //总和为奇数，不能平分
        if (sum % 2 != 0) {
            System.out.println(false);
            return false;
        }

        // 总容量
        int target = sum / 2;
        // dp[j]表示 背包总容量是j，放进物品后，背的最大重量为dp[j]
        int[] dp = new int[target + 1];

        // 初始化
        dp[0] = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        boolean tag = false;
        if (dp[target] == target) {
            tag = true;
        }
        System.out.println(tag);
        return tag;
    }

    /**
     * 最后一块石头的重量
     * 有一堆石头，每块石头的重量都是正整数。
     * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
     * 如果 x == y，那么两块石头都会被完全粉碎；
     * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
     * 最后，最多只会剩下一块石头。返回此石头最小的可能重量。如果没有石头剩下，就返回 0。
     * 示例：
     * 输入：[2,7,4,1,8,1]
     * 输出：1
     *
     * 本题其实就是尽量让石头分成重量相同的两堆，相撞之后剩下的石头最小，这样就化解成01背包问题了
     * @param stones
     */
    public static void lastStoneWeightII(int[] stones) {
        if (stones.length == 0) {
            return;
        }

        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        // 一半
        int target = sum / 2;

        // dp[j]表示容量为j的背包，最多可以背的最大重量
        int[] dp = new int[target + 1];

        // 因为重量都不会是负数，所以dp[j]都初始化为0就可以了

        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        int result = sum - dp[target] - dp[target];
        System.out.println(result);
    }

    /**
     * 目标和
     * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。
     * 对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
     * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
     *
     * 示例：
     * 输入：nums: [1, 1, 1, 1, 1], S: 3
     * 输出：5
     * 数组非空，且长度不会超过 20。
     * 初始的数组的和不会超过 1000。
     */
    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int sum2 = sum + target;
        // 不能整除 表示一种方法都没有
        if (sum2 % 2 != 0) {
            return 0;
        }

        // 背包容量
        int bagSize = sum2 / 2;
        // 填满j这么大容积的包，有dp[j]种方法
        int[] dp = new int[bagSize + 1];

        // 初始化
        // 从递归公式可以看出，在初始化的时候dp[0] 一定要初始化为1，因为dp[0]是在公式中一切递推结果的起源，如果dp[0]是0的话，递归结果将都是0。
        dp[0] = 1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = bagSize; j >= nums[i]; j--) {
                //例如：dp[j]，j 为5，
                //已经有一个1（nums[i]） 的话，有 dp[4]种方法 凑成 容量为5的背包。
                //已经有一个2（nums[i]） 的话，有 dp[3]种方法 凑成 容量为5的背包。
                //已经有一个3（nums[i]） 的话，有 dp[2]中方法 凑成 容量为5的背包
                //已经有一个4（nums[i]） 的话，有 dp[1]中方法 凑成 容量为5的背包
                //已经有一个5 （nums[i]）的话，有 dp[0]中方法 凑成 容量为5的背包
                //那么凑整dp[5]有多少方法呢，也就是把所有的 dp[j - nums[i]] 累加起来。
                dp[j] += dp[j - nums[i]];
            }
        }
        System.out.println(dp[bagSize]);
        return dp[bagSize];
    }

    /**
     * 一和零

     * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
     * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
     * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
     *
     * 示例 1：
     * 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3 输出：4
     * 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
     *
     * m :0的个数  n：1的个数
     */
    public static int findMaxForm(String[] strs, int m, int n) {
        //dp[i][j]：最多有i个0和j个1的strs的最大子集的大小
        int[][] dp = new int[m + 1][n + 1];

        // 3、初始化 非0下标也初始化为0
        dp[0][0] = 0;

        // 记录1的数量
        int oneNum;
        // 记录0的数量
        int zeroNum;

        // 遍历strs 遍历物品
        for (String str : strs) {
            oneNum = 0;
            zeroNum = 0;
            for (char c : str.toCharArray()) {
                if (c == '1') {
                    oneNum++;
                } else {
                    zeroNum++;
                }
            }

            // 遍历背包  物品重量有了2个维度
            for (int i = m; i >= zeroNum; i--) {
                for (int j = n; j >= oneNum; j--) {
                    // dp[i][j] 可以由前一个strs里的字符串推导出来，strs里的字符串有zeroNum个0，oneNum个1。
                    // dp[i][j] 就可以是 dp[i - zeroNum][j - oneNum] + 1。
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }
        }
        System.out.println(dp[m][n]);
        return dp[m][n];
    }

}
