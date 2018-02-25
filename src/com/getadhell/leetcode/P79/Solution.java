package com.getadhell.leetcode.P79;

/**
 * https://leetcode.com/problems/word-search/description/
 */
public class Solution {
    private boolean isExist;

    public boolean exist(char[][] board, String word) {
        if (board.length * board[0].length < word.length()) {
            return false;
        }
        isExist = false;
        boolean path[][] = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                ex(board, i, j, word, 0, path);
                if (isExist) {
                    return true;
                }
            }
        }
        return false;
    }


    private void ex(char[][] board, int i, int j, String word, int index, boolean[][] path) {
        if (index == word.length()) {
            isExist = true;
            return;
        }
        if (isExist) {
            return;
        }
        if (i >= board.length || i < 0 || j >= board[i].length || j < 0) {
            return;
        }

        if (path[i][j]) {
            return;
        }

        if (board[i][j] != word.charAt(index)) {
            return;
        }

        path[i][j] = true;

        ex(board, i + 1, j, word, index + 1, path);
        ex(board, i - 1, j, word, index + 1, path);
        ex(board, i, j - 1, word, index + 1, path);
        ex(board, i, j + 1, word, index + 1, path);
        path[i][j] = false;
    }
}