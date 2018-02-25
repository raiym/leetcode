package com.getadhell.leetcode.P172;

/**
 * https://leetcode.com/problems/factorial-trailing-zeroes/description/
 */
public class Solution {
    public int trailingZeroes(int n) {
        int trailingZeros = 0;
        while (n > 0) {
            if (n % 5 != 0) n -= n % 5;
            n /= 5;
            trailingZeros += n;
        }
        return trailingZeros;
    }
}
