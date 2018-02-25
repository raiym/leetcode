package com.getadhell.leetcode.P287;

/**
 * https://leetcode.com/problems/find-the-duplicate-number/description/
 */
public class Solution {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return 0;
    }
}