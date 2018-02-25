package com.getadhell.leetcode.P191;

/**
 * https://leetcode.com/problems/number-of-1-bits/description/
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }
}
