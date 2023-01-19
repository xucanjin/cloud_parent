package com.xu.algorithm.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xucanjin
 * @date 2023/01/17
 * @description 回溯字符串切割问题
 */
public class BackTrack2 {
    public static void main(String[] args) {
        partition("aab");
        restoreIpAddresses("25525511135");
    }

    private static List<List<String>> result = new ArrayList<>();
    private static LinkedList<String> path = new LinkedList<>();

    /**
     * 分割回文串
     * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
     * 返回 s 所有可能的分割方案。
     * 示例: 输入: "aab" 输出: [ ["aa","b"], ["a","a","b"] ]
     */
    public static void partition(String s) {
        backTracking(s, 0);
        System.out.println("partition:" + result);
    }

    private static void backTracking(String s, int startIndex) {
        // 如果起始位置等于s的大小，说明找到了一组分割方案
        if (startIndex == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            //如果是回文
            if (isPalindrome(s, startIndex, i)) {
                path.addLast(s.substring(startIndex, i + 1));
            } else {
                continue;
            }
            backTracking(s, i + 1);
            // 回溯
            path.removeLast();
        }
    }

    //判断是否是回文串
    private static boolean isPalindrome(String s, int startIndex, int end) {
        for (int i = startIndex, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    private static List<String> result1 = new ArrayList<>();

    /**
     * 复原IP地址
     * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
     * 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
     * <p>
     * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。
     * 示例 1：
     * 输入：s = "25525511135"
     * 输出：["255.255.11.135","255.255.111.35"]
     */
    public static void restoreIpAddresses(String s) {
        backTrack(s, 0, 0);
        System.out.println("restoreIpAddresses:" + result1);
    }

    /**
     * @param s
     * @param startIndex
     * @param pointSum   ip地址的.的数量
     */
    public static void backTrack(String s, int startIndex, int pointSum) {
        if (pointSum == 3) {
            // 判断第四段⼦字符串是否合法，如果合法就放进result中
            if (isValid(s, startIndex, s.length() - 1)) {
                result1.add(s);
            }
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (isValid(s, startIndex, i)) {
                //在str的后⾯插⼊⼀个逗点 substring:左闭右开
                s = s.substring(0, i + 1) + "." + s.substring(i + 1);
                pointSum += 1;
                backTrack(s, i + 2, pointSum);
                pointSum -= 1;
                // 回溯 删掉.
                s = s.substring(0, i + 1) + s.substring(i + 2);
            } else {
                break;
            }
        }
    }

    /**
     * 判断字符串s在左闭⼜闭区间[start, end]所组成的数字是否合法
     *
     * @param s
     * @param start
     * @param end
     * @return
     */
    private static Boolean isValid(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        if (s.charAt(start) == '0' && start != end) { // 0开头的数字不合法
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') { // 遇到⾮数字字符不合法
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            // 如果⼤于255了不合法
            if (num > 255) {
                return false;
            }
        }
        return true;
    }


}
