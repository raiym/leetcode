package com.getadhell.leetcode.P342;

/**
 * https://leetcode.com/problems/power-of-four/description/
 */
public class Solution {
    public boolean isPowerOfFour(int num) {
        if (num <= 0) {
            return false;
        }
        int count = 0;
        int t = num & (num - 1);
        if (t == 0) {
            while (num > 0) {
                int k = num & 1;
                if (k == 0) {
                    count++;
                }

                num >>= 1;
            }
            return count % 2 == 0;
        }
        return false;

    }
}