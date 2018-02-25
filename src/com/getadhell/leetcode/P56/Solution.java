package com.getadhell.leetcode.P56;

/**
 * https://leetcode.com/problems/merge-intervals/description/
 */
class Solution {
    public boolean canJump(int[] nums) {
        int i = 0;
        if (nums.length == 1 || nums.length == 0) {
            return true;
        }
        while (i <= nums.length) {
            int maxIndex = 0;
            // System.out.println("maxIndex: " + maxIndex);
            int max = Integer.MIN_VALUE;
            for (int j = i + 1; j < nums.length && j <= i + nums[i]; j++) {
                int c = nums[j] - ((nums.length - 1) - j);
                // System.out.println("j step: " + j + " c: " + c);
                if (c >= 0) { // || maxIndex >= nums.length - 1
                    return true;
                }
                if (c >= max) {

                    maxIndex = j;
                    max = c;
                    // System.out.println("c>= max. max: " + max + " j: " + j);
                }
            }
            if (nums[maxIndex] == 0) {
                // System.out.println("maxIndex: " + maxIndex);
                return false;
            }
            i = maxIndex;
        }
        return false;
    }
}
