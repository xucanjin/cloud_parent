package com.xu.algorithm.dp;

/**
 * @author xucanjin
 * @date 2023/01/12
 * @description 编辑距离相关问题
 */
public class DPProblem7 {
    public static void main(String[] args) {
        minDistance("sea","eat");
        minDistance2("horse", "ros");
        countSubstrings("abc");
        countSubstrings("aaa");
        longestPalindromeSubseq("bbbab");
    }

    /**
     * 两个字符串的删除操作
     * 给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，
     * 每步可以删除任意一个字符串中的一个字符。
     *
     * 输入: "sea", "eat"
     * 输出: 2
     * 解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"
     */
    public static int minDistance(String word1, String word2) {
        //以i-1为结尾的字符串word1，和以j-1位结尾的字符串word2，想要达到相等，所需要删除元素的最少次数。
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        // dp[i][0]：word2为空字符串，以i-1为结尾的字符串word1要删除多少个元素，才能和word2相同呢，很明显dp[i][0] = i。
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= word2.length(); j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= word1.length(); i++) {
            char char1 = word1.charAt(i - 1);
            for (int j = 1; j <= word2.length(); j++) {
                char char2 = word2.charAt(j - 1);
                if (char1 == char2) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //情况一：删word1[i - 1]，最少操作次数为dp[i - 1][j] + 1
                    //情况二：删word2[j - 1]，最少操作次数为dp[i][j - 1] + 1
                    //情况三：同时删word1[i - 1]和word2[j - 1]，操作的最少次数为dp[i - 1][j - 1] + 2
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 2, Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                }
            }
        }
        int result = dp[word1.length()][word2.length()];
        System.out.println("minDistance:" + result);
        return result;
    }

    /**
     * 编辑距离
     * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
     * 你可以对一个单词进行如下三种操作：
     * 插入一个字符
     * 删除一个字符
     * 替换一个字符
     *
     * 示例 1：
     * 输入：word1 = "horse", word2 = "ros"
     * 输出：3 解释： horse -> rorse (将 'h' 替换为 'r') rorse -> rose (删除 'r') rose -> ros (删除 'e')
     */
    public static int minDistance2(String word1, String word2) {
        // 表示以下标i-1为结尾的字符串word1，和以下标j-1为结尾的字符串word2，最少操作次数
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        // 初始化
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= word2.length(); j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= word1.length(); i++) {
            char c1 = word1.charAt(i - 1);
            for (int j = 1; j <= word2.length(); j++) {
                char c2 = word2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //操作一：word1删除一个元素，那么就是以下标i - 2为结尾的word1 与 j-1为结尾的word2的最近编辑距离 再加上一个操作。
                    //即 dp[i][j] = dp[i - 1][j] + 1;
                    //操作二：word2删除一个元素，那么就是以下标i - 1为结尾的word1 与 j-2为结尾的word2的最近编辑距离 再加上一个操作。
                    // 这里有同学发现了，怎么都是删除元素，添加元素去哪了。
                    //word2添加一个元素，相当于word1删除一个元素
                    // 操作三：替换元素，word1替换word1[i - 1]，使其与word2[j - 1]相同，此时不用增删加元素。
                    //可以回顾一下，if (word1[i - 1] == word2[j - 1])的时候我们的操作 是 dp[i][j] = dp[i - 1][j - 1] 对吧。
                    //那么只需要一次替换的操作，就可以让 word1[i - 1] 和 word2[j - 1] 相同。
                    //所以 dp[i][j] = dp[i - 1][j - 1] + 1;
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + 1);
                }
            }
        }
        int i = dp[word1.length()][word2.length()];
        System.out.println("minDistance2:" + i);
        return i;
    }

    /**
     * 回文子串
     * 给定一个字符串，计算这个字符串中有多少个回文子串。回文子串是连续的
     * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
     *
     * 示例 1：
     * 输入："abc"
     * 输出：3
     * 解释：三个回文子串: "a", "b", "c"
     */
    public static int countSubstrings(String s) {
        // 记录回文子串的数量
        int result = 0;
        if (s == null || s.length() == 0) {
            return result;
        }
        int len = s.length();
        // 表示[i,j](包含i和j)这个范围的子串是否是回文子串，如果是dp[i][j]为true，否则为false。
        boolean[][] dp = new boolean[len][len];

        // 从下往上遍历
        for (int i = len - 1; i >= 0; i--) {
            char c1 = s.charAt(i);
            for (int j = i; j < len; j++) {
                char c2 = s.charAt(j);
                if (c1 == c2) {
                    if (j - i <= 1) {
                        dp[i][j] = true;
                        result++;
                    }
                    // j和i之间距离大于1
                    else {
                        if (dp[i + 1][j - 1] == true) {
                            dp[i][j] = true;
                            result++;
                        }
                    }
                }
            }
        }
        System.out.println("countSubstrings:" + result);
        return result;
    }

    /**
     * 最长回文子序列
     * 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
     * 子序列可以不连续
     * 示例 1: 输入: "bbbab" 输出: 4 一个可能的最长回文子序列为 "bbbb"。
     * 示例 2: 输入:"cbbd" 输出: 2 一个可能的最长回文子序列为 "bb"。
     */
    public static int longestPalindromeSubseq(String s) {
        int len = s.length();

        // 字符串s在[i, j]范围内最长的回文子序列的长度为
        int[][] dp = new int[len][len];

        // 当i和j相同时，即只有一个字符时，需要初始化
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }

        for (int i = len - 1; i >= 0; i--) {
            char c1 = s.charAt(i);
            for (int j = i + 1; j < len; j++) {
                char c2 = s.charAt(j);
                if (c1 == c2) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    // s[i]与s[j]不相同，说明s[i]和s[j]的同时加入 并不能增加[i,j]区间回文子序列的长度，
                    // 那么分别加入s[i]、s[j]看看哪一个可以组成最长的回文子序列。
                    //加入s[j]的回文子序列长度为dp[i + 1][j]。
                    //加入s[i]的回文子序列长度为dp[i][j - 1]。
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        int i = dp[0][len - 1];
        System.out.println("longestPalindromeSubseq:" + i);
        return i;
    }
}
