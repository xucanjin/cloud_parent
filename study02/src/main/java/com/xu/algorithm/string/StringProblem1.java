package com.xu.algorithm.string;

/**
 * @author xucanjin
 * @date 2023/01/23
 * @description 字符串问题
 */
public class StringProblem1 {
    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg", 2));
        System.out.println(reverseWords("  hello world  "));

        reverseLeftWords("abcdefg", 2);
        System.out.println(strStr("hello", "ll"));
        System.out.println(repeatedSubstringPattern("abab"));
        System.out.println(repeatedSubstringPattern2("abab"));
    }

    /**
     * 反转字符串II
     * 力扣题目链接:https://leetcode.cn/problems/reverse-string-ii/
     * 给定一个字符串 s 和一个整数 k，从字符串开头算起, 每计数至 2k 个字符，就反转这 2k 个字符中的前 k 个字符。
     * 如果剩余字符少于 k 个，则将剩余字符全部反转。
     * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
     * 示例:
     * 输入: s = "abcdefg", k = 2
     * 输出: "bacdfeg"
     */
    public static String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += 2 * k) {
            // 剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符
            if (i + k <= chars.length) {
                reverse(chars, i, i + k - 1);
            } else {
                // 剩余字符少于 k 个，则将剩余字符全部反转
                reverse(chars, i, chars.length - 1);
            }
        }
        return new String(chars);
    }

    // 定义翻转函数
    public static void reverse(char[] ch, int i, int j) {
        for (; i < j; i++, j--) {
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
        }
    }

    /**
     * 翻转字符串里的单词
     * 力扣题目链接:
     * <p>
     * 给定一个字符串，逐个翻转字符串中的每个单词。
     * 示例 3：
     * 输入: "a good   example"
     * 输出: "example good a"
     * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
     */
    public static String reverseWords(String s) {
        String[] s2 = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = s2.length - 1; i >= 0; i--) {
            if (s2[i] != "") {
                builder.append(s2[i]).append(" ");
            }
        }
        return builder.substring(0, builder.length() - 1);
    }

    /**
     * 剑指Offer58-II.左旋转字符串
     * 力扣题目链接(opens new window)
     * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
     * <p>
     * 示例 1：
     * 输入: s = "abcdefg", k = 2
     * 输出: "cdefgab"
     */
    public static String reverseLeftWords(String s, int n) {
        // 1、反转区间为前n的子串
        // 2、反转区间为n到末尾的子串
        // 3、反转整个字符串

        char[] chars = s.toCharArray();
        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
        reverse(chars, 0, chars.length - 1);
        s = new String(chars);
        System.out.println(s);
        return s;
    }

    /**
     * KMP算法
     * 实现 strStr()
     * 力扣题目链接：https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/
     * <p>
     * 实现 strStr() 函数。
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     * 示例 1: 输入: haystack = "hello", needle = "ll" 输出: 2
     */
    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int[] next = new int[needle.length()];
        getNext(next, needle);

        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == needle.length()) {
                // 得到needle字符串出现的第一个位置
                return i - needle.length() + 1;
            }
        }
        return -1;
    }

    /**
     * 构造next数组
     *
     * @param next
     * @param s
     */
    private static void getNext(int[] next, String s) {
        // 前缀末尾
        int prefix = 0;
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            while (prefix > 0 && s.charAt(i) != s.charAt(prefix)) {
                prefix = next[prefix - 1];
            }
            if (s.charAt(i) == s.charAt(prefix)) {
                prefix++;
            }
            // 更新next数组的值
            next[i] = prefix;
        }
    }

    /**
     * 重复的子字符串
     * 力扣题目链接(opens new window)
     * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
     * 示例 1:
     * 输入: "abab"
     * 输出: True
     * 解释: 可由子字符串 "ab" 重复两次构成。
     */
    public static boolean repeatedSubstringPattern(String s) {
        String s2 = s.substring(1) + s.substring(0, s.length() - 1);
        return s2.contains(s);
    }

    /**
     * KMP
     */
    public static boolean repeatedSubstringPattern2(String s) {
        if (s.equals("")) {
            return false;
        }

        int len = s.length();
        // 原串加个空格(哨兵)，使下标从1开始，这样j从0开始，也不用初始化了
        s = " " + s;
        char[] chars = s.toCharArray();
        int[] next = new int[len + 1];
        // 构造 next 数组过程，j从0开始(空格)，i从2开始
        for (int i = 2, j = 0; i <= len; i++) {
            while (j > 0 && chars[i] != chars[j + 1]) {
                j = next[j];
            }
            if (chars[i] == chars[j + 1]) {
                j++;
            }
            next[i] = j;
            // 最后判断是否是重复的子字符串，这里 next[len] 即代表next数组末尾的值
            if (next[len] > 0 && len % (len - next[len]) == 0) {
                return true;
            }
        }
        return false;
    }
}
