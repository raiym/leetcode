package com.getadhell.leetcode.P7;

/**
 * https://leetcode.com/problems/reverse-integer/description/
 */
public class Solution {
    public int reverse(int x) {
        int znak = 1;
        if (x < 0) {
            znak = -1;
            if (-2147483648 == x) {
                return 0;
            }
            x = -x;

        }
        int answer = 0;
        while (x != 0) {

            answer += x % 10;
            if (x < 10) {
                break;
            }
            if (answer > Integer.MAX_VALUE / 10) {
                System.out.println(answer + " > " + Integer.MAX_VALUE / 10);
                return 0;
            }
            answer *= 10;
            x /= 10;
        }
        return znak * answer;
    }
}
