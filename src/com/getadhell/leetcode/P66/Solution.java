package com.getadhell.leetcode.P66;

/**
 * https://leetcode.com/problems/plus-one/description/
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits.length == 0) {
            int[] ar = new int[1];
            ar[0] = 1;
            return ar;
        }
        digits[digits.length - 1]++;
        if (digits[digits.length - 1] <= 9) {
            return digits;
        }
        digits[digits.length - 1] = 0;
        int add = 1;
        for (int i = digits.length - 2; i >= 0; i--) {
            digits[i] += add;
            if (digits[i] == 10) {
                digits[i] = 0;
                add = 1;
            } else {
                add = 0;
                return digits;
            }
        }
        if (add == 1) {
            return moveOne(digits);
        }
        return digits;
    }

    public int[] moveOne(int[] digits) {
        int[] ar = new int[digits.length + 1];
        ar[0] = 1;
        for (int i = 1; i < ar.length; i++) {
            ar[i] = digits[i - 1];
        }
        return ar;
    }
}
