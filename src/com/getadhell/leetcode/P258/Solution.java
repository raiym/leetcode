package com.getadhell.leetcode.P258;

/**
 * https://leetcode.com/problems/add-digits/description/
 */
public class Solution {
    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        num = num - 9;
        int i = 9;
        while (num % 9 != 0) {
            i--;
            num += 1;

        }
        return i;
    }
}
