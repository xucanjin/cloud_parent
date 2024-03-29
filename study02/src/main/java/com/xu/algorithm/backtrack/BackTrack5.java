package com.xu.algorithm.backtrack;

import java.util.Arrays;

/**
 * @author xucanjin
 * @date 2023/01/19
 * @description 解数独
 */
public class BackTrack5 {
    public static void main(String[] args) {
        solveSudoku();
    }

    /**
     * 解数独
     * 力扣题目链接:https://leetcode.cn/problems/sudoku-solver/
     *
     * 一个数独的解法需遵循如下规则： 数字 1-9 在每一行只能出现一次。
     * 数字 1-9 在每一列只能出现一次。 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
     * 空白格用 '.' 表示。
     * 你可以假设给定的数独只有唯一解。
     * 给定数独永远是 9x9 形式的。
     */
    public static void solveSudoku() {
        char[][] board = new char[9][9];
        for (char[] c : board) {
            Arrays.fill(c, '.');
        }
        if (solveSudokuHelper(board)) {
            for (char[] chars : board) {
                for (char c : chars) {
                    System.out.print(c + "\t");
                }
                System.out.println();
            }
        }
    }

    private static boolean solveSudokuHelper(char[][] board) {
        //「一个for循环遍历棋盘的行，一个for循环遍历棋盘的列，
        // 一行一列确定下来之后，递归遍历这个位置放9个数字的可能性！
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    continue;
                }
                // (i, j) 这个位置放k是否合适
                for (char k = '1'; k <= '9'; k++) {
                    if (isValidSudoku(i, j, k, board)) {
                        board[i][j] = k;
                        if (solveSudokuHelper(board)) {
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                // 9个数都试完了，都不行，那么就返回false
                // 因为如果一行一列确定下来了，这里尝试了9个数都不行，说明这个棋盘找不到解决数独问题的解！
                // 那么会直接返回， 「这也就是为什么没有终止条件也不会永远填不满棋盘而无限递归下去！」
                return false;
            }
        }
        return true;
    }

    /**
     * 判断棋盘是否合法有如下三个维度:
     *     同行是否重复
     *     同列是否重复
     *     9宫格里是否重复
     */
    private static boolean isValidSudoku(int row, int col, char val, char[][] board){
        // 同行是否重复
        for (int i = 0; i < 9; i++){
            if (board[row][i] == val){
                return false;
            }
        }
        // 同列是否重复
        for (int j = 0; j < 9; j++){
            if (board[j][col] == val){
                return false;
            }
        }
        // 9宫格里是否重复
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++){
            for (int j = startCol; j < startCol + 3; j++){
                if (board[i][j] == val){
                    return false;
                }
            }
        }
        return true;
    }
}
