package com.getadhell.leetcode.P41;

/**
 * https://leetcode.com/problems/first-missing-positive/description/
 */
public class Solution {
    public int firstMissingPositive(int[] nums) {
        int d = 1;
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == d) {
                    d++;
                    flag = true;
                    break;
                }
            }
        }
        return d;
    }
}