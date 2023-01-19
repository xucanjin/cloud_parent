package com.xu.algorithm.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author xucanjin
 * @date 2023/01/19
 * @description 回溯子集问题
 */
public class BackTrack3 {
    public static void main(String[] args) {
        subsets(new int[]{1, 2, 3});
        subsetsWithDup(new int[]{1, 2, 2});
        findSubsequences(new int[]{4, 6, 7, 7});
    }

    private static List<List<Integer>> result = new ArrayList<>();// 存放符合条件结果的集合
    /**
     * 用来存放符合条件结果
     */
    private static LinkedList<Integer> path = new LinkedList<>();

    /**
     * 子集
     * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
     * 说明：解集不能包含重复的子集。
     * 示例: 输入: nums = [1,2,3] 输出: [ [3],   [1],   [2],   [1,2,3],   [1,3],   [2,3],   [1,2],   [] ]
     */
    public static List<List<Integer>> subsets(int[] nums) {
        subsetsHelper(nums, 0);
        System.out.println("subsets:" + result);
        return result;
    }

    private static void subsetsHelper(int[] nums, int startIndex) {
        // 遍历这个树的时候，把所有节点都记录下来，就是要求的子集集合
        // 先把结果放到result中
        result.add(new ArrayList<>(path));
        if (startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            subsetsHelper(nums, i + 1);
            // 回溯
            path.removeLast();
        }
    }

    private static List<List<Integer>> result2 = new ArrayList<>();// 存放符合条件结果的集合
    /**
     * 用来存放符合条件结果
     */
    private static LinkedList<Integer> path2 = new LinkedList<>();

    /**
     * 子集II
     * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
     * 说明：解集不能包含重复的子集。
     * <p>
     * 示例:
     * 输入: [1,2,2]
     * 输出: [ [2], [1], [1,2,2], [2,2], [1,2], [] ]
     */
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0) {
            result2.add(path);
            return result2;
        }
        // 排序
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        subsetsWithDupHelper(nums, 0, used);
        System.out.println("subsetsWithDup:" + result2);
        return result2;
    }

    private static void subsetsWithDupHelper(int[] nums, int startIndex, boolean[] used) {
        result2.add(new ArrayList<>(path2));

        for (int i = startIndex; i < nums.length; i++) {
            // 去重
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            path2.add(nums[i]);
            used[i] = true;
            subsetsWithDupHelper(nums, i + 1, used);
            // 回溯
            used[i] = false;
            path2.removeLast();
        }
    }

    private static List<List<Integer>> result3 = new ArrayList<>();// 存放符合条件结果的集合
    /**
     * 用来存放符合条件结果
     */
    private static LinkedList<Integer> path3 = new LinkedList<>();

    /**
     * 递增子序列 不能对数组排序
     * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
     * 示例:
     * 输入: [4, 6, 7, 7]
     * 输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
     */
    public static List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        System.out.println("findSubsequences:" + result3);
        return result3;
    }

    private static void backtracking(int[] nums, int startIndex) {
        if (path3.size() > 1) {
            result3.add(new ArrayList<>(path3));
        }

        // 记录本层元素
        Set<Integer> useSet = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            // 当前元素小于之前取的值 或 值之前已经取过了
            if ((path3.size() > 0 && nums[i] < path3.getLast()) || useSet.contains(nums[i])) {
                continue;
            }
            useSet.add(nums[i]);
            path3.add(nums[i]);
            backtracking(nums, i + 1);
            // 回溯
            path3.removeLast();
        }
    }
}
