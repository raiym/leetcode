package com.getadhell.leetcode.P53;

/**
 * https://leetcode.com/problems/maximum-subarray/description/
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int maxCur = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxCur = Math.max(nums[i], maxCur + nums[i]);
            max = Math.max(max, maxCur);
        }
        return max;
    }
}
