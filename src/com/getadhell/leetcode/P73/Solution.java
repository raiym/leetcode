package com.getadhell.leetcode.P73;

/**
 * https://leetcode.com/problems/set-matrix-zeroes/description/
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        int dif = Integer.MAX_VALUE - 179;
        boolean deleteFirstRow = false;
        boolean deleteFirstColumn = false;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                deleteFirstColumn = true;
            }
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[0][j] == 0) {
                    deleteFirstRow = true;
                }
                if (matrix[i][j] == 0) {
                    matrix[i][0] = dif;
                    matrix[0][j] = dif;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == dif) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 1; j < matrix[0].length; j++) {
            if (matrix[0][j] == dif || matrix[0][j] == 0) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (deleteFirstRow) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if (deleteFirstColumn) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

    }
}
