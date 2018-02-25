package com.getadhell.leetcode.P477;

/**
 * https://leetcode.com/problems/total-hamming-distance/
 */

public class Solution {
    public int totalHammingDistance(int[] nums) {
        int count = 0;
        int bit = 1;
        for (int i = 0; i < 32; i++) {
            int one = 0;
            int zero = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] & bit) == 0) {
                    zero++;
                } else {
                    one++;
                }
            }
            bit = bit << 1;
            count += one * zero;
        }
        return count;
    }
}
