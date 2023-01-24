package com.xu.algorithm.arraylist;

import java.util.Arrays;

/**
 * @author xucanjin
 * @date 2023/01/21
 * @description 数组相关问题
 */
public class ArrayProblem1 {
    public static void main(String[] args) {
        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        System.out.println(removeElement(new int[]{3, 2, 2, 3}, 3));

        sortedSquares(new int[]{-4, -1, 0, 3, 10});
        for (int[] ints : generateMatrix(3)) {
            for (int i : ints) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 二分查找
     * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
     * 输入: nums = [-1,0,3,5,9,12], target = 9
     * 输出: 4
     * 解释: 9 出现在 nums 中并且下标为 4
     */
    public static int search(int[] nums, int target) {
        // 左边界
        int left = 0;
        // 右边界
        int right = nums.length - 1;

        int middle;
        while (left <= right) {
            middle = (left + right) / 2;
            if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    /**
     * 移除元素
     * 力扣题目链接:https://leetcode.cn/problems/remove-element/
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并原地修改输入数组。
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     * 示例 1: 给定 nums = [3,2,2,3], val = 3, 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。 你不需要考虑数组中超出新长度后面的元素。
     */
    public static int removeElement(int[] nums, int val) {
        // 快慢指针
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }

    /**
     * 有序数组的平方
     * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
     * 示例 1： 输入：nums = [-4,-1,0,3,10] 输出：[0,1,9,16,100]
     * 解释：平方后，数组变为 [16,1,0,9,100]，排序后，数组变为 [0,1,9,16,100]
     */
    public static int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        for (int num : nums) {
            System.out.print(num + "\t");
        }
        System.out.println();
        return nums;
    }

    /**
     * 长度最小的子数组
     * 力扣题目链接:https://leetcode.cn/problems/minimum-size-subarray-sum/
     *
     * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
     * 示例：
     * 输入：s = 7, nums = [2,3,1,2,4,3] 输出：2 解释：子数组 [4,3] 是该条件下的长度最小的子数组
     */
    public static int minSubArrayLen(int s, int[] nums) {
        // 起始位置
        int i = 0;
        int result = Integer.MAX_VALUE;
        int sum = 0;
        // j 表示终止位置
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= s) {
                result = Math.min(j - i + 1, result);
                sum = sum - nums[i];
                i++;
            }
        }
        // 不存在
        if (result == Integer.MAX_VALUE) {
            return 0;
        }
        return result;
    }

    /**
     * 螺旋矩阵II
     * 力扣题目链接:
     *
     * 给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
     * 示例:
     * 输入: 3 输出: [ [ 1, 2, 3 ],
     *                [ 8, 9, 4 ],
     *                [ 7, 6, 5 ] ]
     */
    public static int[][] generateMatrix(int n) {
        int loop = 0;  // 控制循环次数
        int[][] res = new int[n][n];

        int startX = 0;
        int startY = 0;
        int offset = 1;
        int count = 1;
        int i, j;
        // 左闭右开
        while (loop++ < n / 2) {
            for (j = startY; j < n - offset; j++) {
                res[startX][j] = count++;
            }
            for (i = startX; i < n - offset; i++) {
                res[i][j] = count++;
            }
            for (; j > startY; j--) {
                res[i][j] = count++;
            }
            for (; i > startX; i--) {
                res[i][j] = count++;
            }
            startX++;
            startY++;
            offset++;
        }
        if (n % 2 == 1) {
            res[startX][startY] = count++;
        }
        return res;
    }
}
