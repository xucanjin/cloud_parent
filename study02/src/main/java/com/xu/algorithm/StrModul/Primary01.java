package com.xu.algorithm.StrModul;

/**
 * @author xucanjin
 * @date 2022/07/08
 * @description
 */
public class Primary01 {

    public static void main(String[] args) {
        String[] strs = new String[]{"fl", "flow", "flight", "flower"};

        String s = longestCommonPrefix(strs);
        System.out.println(s);
    }

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串""。
     * <p>
     * 示例 1：
     * <p>
     * 输入：strs = ["flower","flow","flight"]
     * 输出："fl"
     *
     * @param strs
     * @return
     */
    private static String longestCommonPrefix(String[] strs) {
        // 默认第一个是公共前缀
        String pre = strs[0];

        int index = 1;
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(pre) != 0) {
                pre = pre.substring(0, pre.length() - 1);
            }
        }
        return pre;
    }
}
