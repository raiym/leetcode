package com.getadhell.leetcode.P238;

/**
 * https://leetcode.com/problems/product-of-array-except-self/description/
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0] = 1;
        right[right.length - 1] = 1;

        for (int i = 1; i < left.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        for (int i = right.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            output[i] = left[i] * right[i];
        }

        return output;
    }
}
