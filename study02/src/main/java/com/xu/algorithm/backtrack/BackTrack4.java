package com.xu.algorithm.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xucanjin
 * @date 2023/01/19
 * @description 回溯全排列
 */
public class BackTrack4 {
    public static void main(String[] args) {
        permute(new int[]{1, 2, 3});
        permuteUnique(new int[]{1, 1, 2});
        solveNQueens(4);
    }

    private static List<List<Integer>> result = new ArrayList<>();// 存放符合条件结果的集合
    /**
     * 用来存放符合条件结果
     */
    private static LinkedList<Integer> path = new LinkedList<>();

    /**
     * 全排列
     * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
     * 示例:
     * 输入: [1,2,3]
     * 输出: [ [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1] ]
     */
    public static List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return result;
        }
        // 标记元素是否使用过
        boolean[] used = new boolean[nums.length];
        permuteHelper(nums, used);
        System.out.println("permute:" + result);
        return result;
    }

    private static void permuteHelper(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 如果元素使用过，跳过这个元素
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            permuteHelper(nums, used);
            // 回溯
            used[i] = false;
            path.removeLast();
        }
    }

    private static List<List<Integer>> result2 = new ArrayList<>();// 存放符合条件结果的集合
    /**
     * 用来存放符合条件结果
     */
    private static LinkedList<Integer> path2 = new LinkedList<>();

    /**
     * 全排列 II
     * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
     * <p>
     * 示例 1：
     * 输入：nums = [1,1,2]
     * 输出： [[1,1,2], [1,2,1], [2,1,1]]
     */
    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backTrack(nums, used);
        System.out.println("permuteUnique:" + result2);
        return result2;
    }

    private static void backTrack(int[] nums, boolean[] used) {
        if (path2.size() == nums.length) {
            result2.add(new ArrayList<>(path2));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 去重
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path2.add(nums[i]);
            backTrack(nums, used);
            // 回溯
            used[i] = false;
            path2.removeLast();
        }
    }

    private static List<List<String>> res = new ArrayList<>();

    /**
     * N皇后
     * <p>
     * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
     * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
     * 皇后们的约束条件：
     * 不能同行
     * 不能同列
     * 不能同斜线
     * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
     * 输入：n = 4
     * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
     * 解释：如上图所示，4 皇后问题存在两个不同的解法。
     */
    public static List<List<String>> solveNQueens(int n) {
        // 棋盘
        char[][] chessboard = new char[n][n];
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }
        backTrack(n, 0, chessboard);
        System.out.println("solveNQueens:" + res);
        return res;
    }

    private static void backTrack(int n, int row, char[][] chessboard) {
        // 行数等于n
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (char[] c : chessboard) {
                list.add(String.copyValueOf(c));
            }
            res.add(list);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isValid(row, i, n, chessboard)) {
                chessboard[row][i] = 'Q';
                backTrack(n, row + 1, chessboard);
                // 回溯
                chessboard[row][i] = '.';
            }
        }
    }

    /**
     * 验证棋盘是否合法
     *
     * @param row
     * @param col
     * @param n
     * @param chessboard
     * @return
     */
    private static boolean isValid(int row, int col, int n, char[][] chessboard) {
        // 检查列
        for (int i = 0; i < row; ++i) { // 相当于剪枝
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }

        // 检查45度对角线
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        // 检查135度对角线
        for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
