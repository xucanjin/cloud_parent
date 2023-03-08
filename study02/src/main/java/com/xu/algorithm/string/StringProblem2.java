package com.xu.algorithm.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author xucanjin
 * @date 2023/03/06
 * @description
 */
public class StringProblem2 {
    public static void main(String[] args) {

        //System.out.println(getMaxStr("test",""));
        //subList("abc");

        lengthOfLongestSubstring("abcabcbb");
    }

    /**
     * 找字符串字典序最大的子序列 ：既然要找最大的字典序，肯定要找开头最大
     */
    public static String getMaxStr(String s, String t) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        char c = chars[chars.length - 1];
        int max = s.indexOf(String.valueOf(c));
        t += c;

        if (max == s.length() - 1) {
            return t;
        } else {
            s = s.substring(max + 1);
            return getMaxStr(s, t);
        }
    }


    /**
     * 求字符串的所有子序列 子序列包含空字符串
     */
    public static List<String> subList(String s) {
        char[] chars = s.toCharArray();
        List<String> ans = new ArrayList<>();
        String path = "";
        process(chars, 0, ans, path);
        ans.forEach(i -> System.out.println(i));
        return ans;
    }

    private static void process(char[] chars, int index, List<String> ans, String path) {
        if (index == chars.length) {
            ans.add(path);
            return;
        }
        // 不要index位置的字符  不要a
        process(chars, index + 1, ans, path);

        // 要index位置的字符  要a
        process(chars, index + 1, ans, path + chars[index]);
    }

    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        //return fun1(s);
        return fun2(s);
    }

    /**
     * 暴力递归
     *
     * @param s
     * @return
     */
    private static int fun1(String s) {
        char[] chars = s.toCharArray();
        Set<String> ans = new HashSet<>();
        String s2 = "";
        for (int i = 0; i < chars.length; i++) {
            s2 = chars[i] + "";
            ans.add(s2);
            for (int j = i + 1; j < chars.length; j++) {
                s2 += chars[j];
                if (s2.indexOf(chars[j]) != s2.lastIndexOf(chars[j])) {
                    break;
                }
                if (chars[j] == chars[i]) {
                    break;
                }
                ans.add(s2);
            }
        }
        int i = 1;
        for (String an : ans) {
            if (an.length() > i) {
                i = an.length();
            }
        }
        System.out.println(i);
        return i;
    }

    private static int fun2(String s) {
        HashSet<Character> set = new HashSet<>();
        int len = 0;
        // 右指针
        int rk = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                set.remove(s.charAt(i-1));
            }
            // rk在add进set后会再加一
            while (rk < s.length() && !set.contains(s.charAt(rk))) {
                set.add(s.charAt(rk));
                rk++;
            }
            len = Math.max(len, rk - i);
        }
        System.out.println(len);
        return len;
    }
}
