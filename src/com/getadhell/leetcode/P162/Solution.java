package com.getadhell.leetcode.P162;

/**
 * https://leetcode.com/problems/find-peak-element/description/
 */
public class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int i = 0;
        while (i < nums.length - 1) {
            if (nums[i] > nums[i + 1]) {
                return i;
            } else {
                i++;
            }
        }
        if (nums.length - 2 >= 0 && nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }
        return -1;
    }
}
