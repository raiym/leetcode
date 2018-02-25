package com.getadhell.leetcode.P136;

/**
 * https://leetcode.com/problems/single-number/description/
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int answer = 0;
        for (int num : nums) {
            answer ^= num;
        }
        return answer;
    }
}
