package com.getadhell.leetcode.P240;

/**
 * https://leetcode.com/problems/search-a-2d-matrix-ii/description/
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        // printArray(matrix);
        int maxRowIndex = getRowNumber(matrix, target);
        // System.out.println("Max Row Index: " + maxRowIndex);
        for (int i = 0; i < matrix.length && i <= maxRowIndex; i++) {
            if (bs(matrix[i], target)) {
                return true;
            }
        }
        return false;
    }

    private int getRowNumber(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length - 1;
        int index = matrix.length / 2;
        while (true) {
            index = (start + end) / 2;
            if (index == start) {
                // if (nums[)
                index++;
                return index;
            }
            if (index >= end) {
                return index + 1;
            }
            // System.out.println( start + ":" + end);

            if (matrix[index][0] <= target) {
                start = index;
            } else {
                end = index;
            }
        }
    }

    private boolean bs(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }
        int start = 0;
        int end = nums.length - 1;
        int index;
        while (true) {
            index = (start + end) / 2;
            if (index == start) {
                // System.out.println("STart");
                if (nums[start] < target) {
                    index++;
                }
                break;
            }
            if (index >= end) {
                index++;
                break;
            }

            if (nums[index] <= target) {
                start = index;
            } else {
                end = index;
            }
        }
        // System.out.println("Answer: " + nums[index] + " index: " + index);
        if (index >= nums.length) {
            return false;
        }
        return (nums[index] == target);
    }

    private void printArray(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sb.append(matrix[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
