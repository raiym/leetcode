package com.getadhell.leetcode.P36;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/valid-sudoku/description/
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board.length % 3 != 0 || board[0].length % 3 != 0) {
            return false;
        }
        Set<Character>[] rows = new HashSet[10];
        Set<Character>[] columns = new HashSet[10];

        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board[i].length; j += 3) {
                // System.out.println("NINE BEGINS");
                char[] a = new char[10];
                for (int p = i; p - i < 3; p++) {
                    for (int q = j; q - j < 3; q++) {
                        if (rows[p] == null) {
                            rows[p] = new HashSet<>();
                        }
                        if (columns[q] == null) {
                            columns[q] = new HashSet<>();
                        }

                        // System.out.println(String.format("p = %d, q = %d, board[p][q] = %c", p, q, board[p][q]));
                        if (board[p][q] != '.') {
                            if (rows[p].contains(board[p][q]) || columns[q].contains(board[p][q])) {
                                return false;
                            }

                            if (a[board[p][q] - 48] != 0) {
                                return false;
                            }
                            rows[p].add(board[p][q]);
                            columns[q].add(board[p][q]);
                            a[board[p][q] - 48] = 1;
                        }
                    }
                }
                // System.out.println("NINE ENDS");
            }
        }
        return true;
    }
}