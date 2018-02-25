package com.getadhell.leetcode.P378;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
 */
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int[] a = new int[matrix.length * matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                a[i * (matrix.length) + j] = matrix[i][j];
            }
        }
        Arrays.sort(a);
        return a[k - 1];
    }
}