package com.getadhell.leetcode.P75;

/**
 * https://leetcode.com/problems/sort-colors/description/
 */
public class Solution {
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sortColors(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int low = 0;
        int high = nums.length - 1;

        for (int i = low; i <= high; ) {
            if (nums[i] == 0) {
                swap(nums, i, low);
                low++;
                i++;

            } else if (nums[i] == 2) {
                swap(nums, i, high);
                high--;
            } else {
                i++;
            }
        }
    }
}
