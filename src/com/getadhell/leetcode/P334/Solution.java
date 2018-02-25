package com.getadhell.leetcode.P334;

/**
 * https://leetcode.com/problems/increasing-triplet-subsequence/description/
 */
public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE;
        int big = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= small) small = n;
            else if (n <= big) big = n;
            else return true;
        }
        return false;
    }
}
