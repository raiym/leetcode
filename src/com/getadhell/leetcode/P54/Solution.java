package com.getadhell.leetcode.P54;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/spiral-matrix/description/
 */
class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new ArrayList<>();
        }
        return move(matrix);
    }

    public List<Integer> move(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int currentRow = 0;
        int currentColumn = 0;
        int status = 0;
        while (true) {
            boolean step = false;
            switch (status) {
                case 0:
                    if (currentColumn == matrix[currentRow].length || visited[currentRow][currentColumn]) {
                        currentColumn--;
                        currentRow++;
                        status = 1;
                        continue;
                    }
                    list.add(matrix[currentRow][currentColumn]);
                    visited[currentRow][currentColumn] = true;
                    currentColumn++;
                    step = true;
                    break;
                case 1:
                    if (currentRow == matrix.length || visited[currentRow][currentColumn]) {
                        currentRow--;
                        currentColumn--;
                        status = 2;
                        continue;
                    }
                    list.add(matrix[currentRow][currentColumn]);
                    visited[currentRow][currentColumn] = true;
                    currentRow++;
                    step = true;
                    break;
                case 2:
                    System.out.println("CurrentRow: " + currentRow);
                    if (currentColumn == -1 || visited[currentRow][currentColumn]) {
                        currentColumn++;
                        currentRow--;
                        status = 3;
                        continue;
                    }
                    list.add(matrix[currentRow][currentColumn]);
                    visited[currentRow][currentColumn] = true;
                    currentColumn--;
                    step = true;
                    break;
                case 3:
                    if (currentRow == -1 || visited[currentRow][currentColumn]) {
                        currentRow++;
                        currentColumn++;
                        status = 0;
                        continue;
                    }
                    list.add(matrix[currentRow][currentColumn]);
                    visited[currentRow][currentColumn] = true;
                    currentRow--;
                    step = true;
                    break;
            }

            if (!step || list.size() == matrix[0].length * matrix.length) {
                break;
            }
        }

        return list;
    }
}