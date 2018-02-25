package com.getadhell.leetcode.P198;

/**
 * https://leetcode.com/problems/house-robber/description/
 */
public class Solution {
    private static int max(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = max(nums[0], nums[1]);
        for (int house = 2; house < nums.length; house++) {
            dp[house] = max(nums[house] + dp[house - 2], dp[house - 1]);
        }
        return dp[nums.length - 1];
    }
}
