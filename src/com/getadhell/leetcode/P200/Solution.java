package com.getadhell.leetcode.P200;

/**
 * https://leetcode.com/problems/number-of-islands/description/
 */
public class Solution {
    public int numIslands(char[][] grid) {
        int answer = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    answer++;
                    calc(grid, i, j);
                }
            }
        }
        return answer;
    }

    private void calc(char[][] grid, int i, int j) {
        if (i < 0 || i > grid.length - 1) {
            return;
        }
        if (j < 0 || j > grid[i].length - 1) {
            return;
        }
        if (grid[i][j] == '0') {
            return;
        }
        // System.out.println(grid[i][j]);
        grid[i][j] = '0';
        calc(grid, i + 1, j);
        calc(grid, i - 1, j);
        calc(grid, i, j - 1);
        calc(grid, i, j + 1);
    }
}