package com.getadhell.leetcode.P413;

/**
 * https://leetcode.com/problems/arithmetic-slices/
 */
public class Solution {
    public int numberOfArithmeticSlices(int[] a) {
        if (a == null || a.length < 3) {
            return 0;
        }
        int numberOfSlices = 0;
        int cursor = 0;
        for (int i = 0; i < a.length - 2; i++) {
            if (a[i + 1] - a[i] == a[i + 2] - a[i + 1]) {
                cursor++;
                numberOfSlices += cursor;
            } else {
                cursor = 0;
            }
        }
        return numberOfSlices;

    }
}
