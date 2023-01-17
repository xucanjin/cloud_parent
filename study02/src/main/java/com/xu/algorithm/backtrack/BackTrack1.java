package com.xu.algorithm.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xucanjin
 * @date 2023/01/16
 * @description 回溯求组合问题
 */
public class BackTrack1 {
    public static void main(String[] args) {
        combine1(4, 2);
        combinationSum3(3, 7);
        letterCombinations("34");

        combinationSum(new int[]{2, 3, 6, 7}, 7);
        combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
    }

    private static List<List<Integer>> result = new ArrayList<>();
    private static LinkedList<Integer> path = new LinkedList<>();

    /**
     * 组合
     * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
     * <p>
     * 示例:
     * 输入: n = 4, k = 2
     * 输出:[[2,4],[3,4],[2,3],[1,2],[1,3],[1,4]]
     */
    public static void combine1(int n, int k) {
        combineHelper(n, k, 1);
        System.out.println("combine1:" + result);
    }

    /**
     * 每次从集合中选取元素，可选择的范围随着选择的进行而收缩，调整可选择的范围，就是要靠startIndex
     *
     * @param startIndex 用来记录本层递归的中，集合从哪里开始遍历（集合就是[1,...,n] ）。
     */
    private static void combineHelper(int n, int k, int startIndex) {
        // 如果path的元素个数等于k
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            combineHelper(n, k, i + 1);
            // 恢复现场
            path.removeLast();
        }
    }

    private static List<List<Integer>> result3 = new ArrayList<>();
    /**
     * 存储遍历到的元素  LinkedList:增加和删除的操作效率更高
     */
    private static LinkedList<Integer> path3 = new LinkedList<>();

    /**
     * 组合总和III
     * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
     * <p>
     * 说明：
     * 所有数字都是正整数。
     * 解集不能包含重复的组合。
     * 示例 1: 输入: k = 3, n = 7 输出: [[1,2,4]]
     * 示例 2: 输入: k = 3, n = 9 输出: [[1,2,6], [1,3,5], [2,3,4]
     */
    public static void combinationSum3(int k, int n) {
        backTracking(n, k, 1, 0);
        System.out.println("combinationSum3:" + result3);
    }

    /**
     * @param targetSum  目标和
     * @param k          个数
     * @param startIndex
     * @param sum        数组总和
     */
    private static void backTracking(int targetSum, int k, int startIndex, int sum) {
        // 减枝
        if (sum > targetSum) {
            return;
        }

        // path的个数等于k
        if (path3.size() == k) {
            if (sum == targetSum) {
                result3.add(new ArrayList<>(path3));
                return;
            }
        }
        // 减枝 i <= 9 - (k - path.size()) + 1
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            path3.add(i);
            sum += i;
            backTracking(targetSum, k, i + 1, sum);
            // 恢复现场
            sum -= i;
            path3.removeLast();
        }
    }

    //设置全局列表存储最后的结果
    private static List<String> list = new ArrayList<>();

    /**
     * 初始对应所有的数字，为了直接对应2-9，新增了两个无效的字符串""
     */
    private static String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    /**
     * 电话号码的字母组合
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     * <p>
     * 示例:
     * 输入："23"
     * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     */
    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return list;
        }
        //迭代处理
        backTracking(digits, 0);
        System.out.println("letterCombinations:" + list);
        return list;
    }

    private static StringBuilder builder = new StringBuilder();

    private static void backTracking(String digits, int index) {
        // 终止条件
        if (index == digits.length()) {
            list.add(builder.toString());
            return;
        }
        // 将字符转为数字  '2'- '0'得到数字2
        int n = digits.charAt(index) - '0';
        //Integer integer = Integer.valueOf(String.valueOf(digits.charAt(index)));

        //得到第一个数字对应的字符串
        String s = numString[n];

        for (int i = 0; i < s.length(); i++) {
            builder.append(s.charAt(i));
            // 遍历下一个数字
            backTracking(digits, index + 1);
            // 恢复现场
            builder.deleteCharAt(builder.length() - 1);
        }
    }


    private static List<List<Integer>> result4 = new ArrayList<>();
    private static LinkedList<Integer> path4 = new LinkedList<>();

    /**
     * 组合总和
     * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * candidates 中的数字可以无限制重复被选取。
     * 说明：
     * 所有数字（包括 target）都是正整数。
     * 解集不能包含重复的组合。
     * 示例 1：
     * 输入：candidates = [2,3,6,7], target = 7,
     * 所求解集为： [ [7], [2,2,3] ]
     */
    private static void combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTrackingSum(candidates, target, 0, 0);
        System.out.println("combinationSum:" + result4);
    }

    private static void backTrackingSum(int[] candidates, int target, int sum, int startIndex) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result4.add(new ArrayList<>(path4));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            // 减枝 如果 sum + candidates[i] > target 就终止遍历
            if (sum + candidates[i] > target) {
                break;
            }
            sum += candidates[i];
            path4.add(candidates[i]);
            // 元素可以重复使用，所以传i而不是i+1
            backTrackingSum(candidates, target, sum, i);
            // 回溯
            sum -= candidates[i];
            // 回溯
            path4.removeLast();
        }
    }


    private static LinkedList<Integer> path5 = new LinkedList<>();
    private static List<List<Integer>> ans = new ArrayList<>();
    private static boolean[] used;

    /**
     * 组合总和II
     * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * candidates 中的每个数字在每个组合中只能使用一次。
     * 说明： 所有数字（包括目标数）都是正整数。解集不能包含重复的组合。
     * 示例 1:
     * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
     * [1, 7],[1, 2, 5], [2, 6], [1, 1, 6]
     */
    public static void combinationSum2(int[] candidates, int target) {
        used = new boolean[candidates.length];
        // 加标志数组，用来辅助判断同层节点是否已经遍历
        Arrays.fill(used, false);
        Arrays.sort(candidates);
        backTracking(candidates, target, 0, 0);
        System.out.println("combinationSum2:" + ans);
    }

    private static void backTracking(int[] candidates, int target, int sum, int startIndex) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            ans.add(new ArrayList<>(path5));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            // 去重操作 前一个节点未使用过且当前元素和前一个元素值相同则遍历下一个元素
            if (i>0 && candidates[i] == candidates[i - 1] && used[i - 1] == false) {
                continue;
            }
            // 减枝
            if (sum + candidates[i] > target) {
                break;
            }
            sum += candidates[i];
            path5.add(candidates[i]);
            used[i] = true;
            backTracking(candidates, target, sum, i + 1);
            // 回溯
            sum -= candidates[i];
            path5.removeLast();
            used[i] = false;
        }
    }
}
