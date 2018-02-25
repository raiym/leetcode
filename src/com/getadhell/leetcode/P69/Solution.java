package com.getadhell.leetcode.P69;

/**
 * https://leetcode.com/problems/sqrtx/description/
 */
public class Solution {
    public int mySqrt(int x) {
        if (x == 1) {
            return 1;
        }
        double start = 0;
        double end = (double) x;
        double point;
        while (true) {
            point = (start + end) / 2.0;
            // System.out.println(point * point);
            if (Math.abs(point * point - x) < 0.01) {
                int answer = (int) point;
                if ((answer + 1) * (answer + 1) == x) {
                    return answer + 1;
                }
                return answer;
            } else if (point * point - x > 0.0) {
                end = (start + end) / 2.0;
            } else if (point * point - x < 0.0) {
                start = (start + end) / 2.0;
            }
        }
    }
}
