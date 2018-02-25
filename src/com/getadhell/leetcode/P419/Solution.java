package com.getadhell.leetcode.P419;

/**
 * https://leetcode.com/problems/battleships-in-a-board/
 */
public class Solution {
    public int countBattleships(char[][] board) {
        int count = 0;
        if (board.length == 0) {
            return count;
        }
        if (board[0].length == 0) {
            return 0;
        }
        if (board[0][0] == 'X') {
            count++;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X') {
                    if (i == 0 && j > 0 && board[0][j - 1] != 'X') {
                        count++;
                    }
                    if (j == 0 && i > 0 && board[i - 1][j] != 'X') {
                        count++;

                    }
                    if (i > 0 && board[i - 1][j] != 'X' && j > 0 && board[i][j - 1] != 'X') {
                        count++;
                    }
                }

            }
        }
        return count;
    }
}
