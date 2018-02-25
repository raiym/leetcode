package com.getadhell.leetcode.P62;

/**
 * https://leetcode.com/problems/unique-paths/description/
 */
public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] mn = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            mn[i][1] = 1;
        }
        for (int i = 1; i <= n; i++) {
            mn[1][i] = 1;
        }
        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                mn[i][j] = mn[i - 1][j] + mn[i][j - 1];
            }
        }
        return mn[m][n];
    }
}
