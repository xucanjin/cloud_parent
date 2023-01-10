package com.xu.algorithm.dp;

import java.util.Arrays;

/**
 * @author xucanjin
 * @date 2023/01/07
 * @description
 */
public class DPProblem6 {
    public static void main(String[] args) {
        lengthOfList(new int[]{10, 9, 2, 5, 3, 7, 101, 18});

        findLengthOfLCIS(new int[]{1, 3, 5, 4, 7});

        findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7});
        longestCommonSubsequence("abcde", "ace");
        maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println("isSubsequence:" + isSubsequence("abc", "ahbgdc"));
        numDistinct("babgbag", "bag");
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
        System.out.println("lengthOfList:"+result);
        return result;
    }

    /**
     * 最长连续递增子序列
     * nums = [1,3,5,4,7]
     * 输出：3
     * 解释：最长连续递增序列是 [1,3,5], 长度为3。
     * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。
     */
    public static int findLengthOfLCIS(int[] nums) {
        // dp[i]：以下标i为结尾的连续递增的子序列长度为dp[i]。
        int[] dp = new int[nums.length];

        Arrays.fill(dp, 1);

        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            // 要求连续递增子序列，所以就必须比较nums[i]与nums[i - 1]
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
            if (dp[i] > result) {
                result = dp[i];
            }
        }
        System.out.println("findLengthOfLCIS:" + result);
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
        // 因为dp[i][j]表示的是i-1和j-1结尾的数组，所以长度需要+1
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
        System.out.println("findLength："+result);
        System.out.println(builder.toString());
        return result;
    }

    /**
     * 最长公共子序列
     * 两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
     * 若这两个字符串没有公共子序列，则返回 0。
     * 输入：text1 = "abcde", text2 = "ace" 输出：3
     * 解释：最长公共子序列是 "ace"，它的长度为 3。
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        //dp[i][j]：长度为[0, i - 1]的字符串text1与长度为[0, j - 1]的字符串text2的最长公共子序列为dp[i][j]
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        // test1[0, i-1]和空串的最长公共子序列自然是0，所以dp[i][0] = 0;
        //同理dp[0][j]也是0。
        //其他下标都是随着递推公式逐步覆盖，初始为多少都可以，那么就统一初始为0。

        for (int i = 1; i <= text1.length(); i++) {
            // 得到字符串对应位置的字符
            char char1 = text1.charAt(i - 1);
            for (int j = 1; j <= text2.length(); j++) {
                char char2 = text2.charAt(j - 1);
                if (char1 == char2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }

            }
        }
        System.out.println("longestCommonSubsequence:"+dp[text1.length()][text2.length()]);
        return dp[text1.length()][text2.length()];
    }

    /**
     * 最大子序和
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * 示例: 输入: [-2,1,-3,4,-1,2,1,-5,4] 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     */
    public static int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 以nums[i]为结尾的最大连续子序列和
        int[] dp = new int[nums.length];

        dp[0] = nums[0];

        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            System.out.print(dp[i]+"\t");
            if (result < dp[i]) {
                result = dp[i];
            }
        }
        System.out.println("maxSubArray:" + result);
        return result;
    }

    /**
     * 判断子序列
     * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
     * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
     * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
     *
     * 示例 1： 输入：s = "abc", t = "ahbgdc" 输出：true
     * 示例 2： 输入：s = "axc", t = "ahbgdc" 输出：false
     */
    public static boolean isSubsequence(String s, String t) {
        // dp[i][j] 表示以下标i-1为结尾的字符串s，和以下标j-1为结尾的字符串t，相同子序列的长度
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        // 都初始化为0

        for (int i = 1; i <= s.length(); i++) {
            char ch1 = s.charAt(i - 1);
            for (int j = 1; j <= t.length(); j++) {
                char ch2 = t.charAt(j - 1);
                if (ch1 == ch2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        // 如果2个字符串相同子序列的长度等于s这个字符串的长度，表示s是t的子序列
        if (dp[s.length()][t.length()] == s.length()) {
            return true;
        }
        return false;
    }

    /**
     * 不同的子序列
     * 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
     *
     * 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。
     * （例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
     * s="babgbag", t ="bag", 输出5
     */
    public static int numDistinct(String s, String t) {
        // 以i-1为结尾的s子序列中出现以j-1为结尾的t的个数
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        for (int i = 0; i < t.length() + 1; i++) {
            dp[0][i] = 0;
        }
        // s 中的空字符串个数,特殊情况dp[0][0]=1
        for (int i = 0; i < s.length() + 1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= s.length(); i++) {
            char char1 = s.charAt(i - 1);
            for (int j = 1; j <= t.length(); j++) {
                char char2 = t.charAt(j - 1);
                // 求得是s中包含t的情况，所以只需要考虑s就行
                if (char1 == char2) {
                    // 例如： s：bagg 和 t：bag ，s[3] 和 t[2]是相同的，
                    // 但是字符串s也可以不用s[3]来匹配，即用s[0]s[1]s[2]组成的bag。
                    //当然也可以用s[3]来匹配，即：s[0]s[1]s[3]组成的bag。
                    //所以当s[i - 1] 与 t[j - 1]相等时，dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        int i = dp[s.length()][t.length()];
        System.out.println("numDistinct:" + i);
        return i;
    }
}
