package com.getadhell.leetcode.P300;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/description/
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] a = new int[nums.length];
        int max = 1;
        a[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int value = nums[i];
            int j = i - 1;
            while (true) {
                if (j == -1) {
                    if (a[i] == 0) {
                        a[i] = 1;
                    }
                    break;
                }
                if (nums[i] > nums[j]) {
                    if (a[i] < a[j] + 1) {
                        a[i] = a[j] + 1;
                    }
                    if (max < a[i]) {
                        max = a[i];
                    }
                } else if (nums[i] == nums[j]) {
                    if (a[i] < a[j]) {
                        a[i] = a[j];
                    }

                }
                j--;
            }
        }
        // printArray(nums);
        // printArray(a);
        return max;
    }

    public void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
