package com.getadhell.leetcode.P48;

/**
 * https://leetcode.com/problems/rotate-image/description/
 */
public class Solution {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length / 2; j++) {
                swapElements(matrix, i, j, i, matrix[i].length - 1 - j);
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                int row = i;
                int column = matrix.length - 1 - j;
                int row2 = j;
                int column2 = matrix.length - 1 - i;
                swapElements(matrix, row, column, row2, column2);
            }
        }
    }

    private void swapElements(int[][] a, int i, int j, int p, int q) {
        int t = a[i][j];
        a[i][j] = a[p][q];
        a[p][q] = t;
    }
}
