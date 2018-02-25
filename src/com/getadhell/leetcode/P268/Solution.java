package com.getadhell.leetcode.P268;

/**
 * https://leetcode.com/problems/missing-number/description/
 */
public class Solution {
    public int missingNumber(int[] nums) {
        int sum = ((nums.length + 1) * (nums.length)) / 2;
        int sum2 = 0;
        for (int i = 0; i < nums.length; i++) {
            sum2 += nums[i];
        }
        return sum - sum2;
    }
}