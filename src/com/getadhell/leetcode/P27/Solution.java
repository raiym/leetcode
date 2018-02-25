package com.getadhell.leetcode.P27;

/**
 * https://leetcode.com/problems/remove-element/description/
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                swap(nums, i, j);
                j++;
            }
        }
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
