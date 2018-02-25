package com.getadhell.leetcode.P189;

/**
 * https://leetcode.com/problems/rotate-array/description/
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        if (k == 0) {
            return;
        }
        k--;
        int[] result = new int[nums.length];
        for (int i = 0; i <= k; i++) {
            result[i] = nums[nums.length - 1 - k + i];
        }
        for (int i = k + 1; i < nums.length; i++) {
            result[i] = nums[i - k - 1];
        }
        System.out.println(result[0]);
        System.arraycopy(result, 0,
                nums, 0,
                result.length);
    }
}
