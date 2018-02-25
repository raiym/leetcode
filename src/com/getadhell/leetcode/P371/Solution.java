package com.getadhell.leetcode.P371;

/**
 * https://leetcode.com/problems/sum-of-two-integers/description/
 */
public class Solution {
    public int getSum(int a, int b) {
        int answer = 0;
        int cursor = 1;
        int c = 0;
        for (int i = 0; i < 32; i++) {
            answer ^= (a & cursor) ^ (b & cursor) ^ (c << i);
            if (major(a & cursor, b & cursor, c)) {
                c = 1;
            } else {
                c = 0;
            }
            cursor <<= 1;
        }
        return answer;
    }

    private boolean major(int a, int b, int c) {
        return ((a != 0 && b != 0)
                || (a != 0 && c != 0)
                || (b != 0 && c != 0)
        );
    }
}
