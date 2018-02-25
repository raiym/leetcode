package com.getadhell.leetcode.P50;

/**
 * https://leetcode.com/problems/powx-n/description/
 */
class Solution {
    public double myPow(double x, int n) {
        if (x == 1.0 || n == 0) {
            return 1.0;
        }
        if (x == -1.0) {
            if (n % 2 == 0) {
                return 1.0;
            } else {
                return -1.0;
            }
        }
        return doIt(x, n);
    }

    public double doIt(double x, int n) {
        double answer = 1.0;
        if (n < 0) {
            if (n == -2147483648) {
                return 0.0;
            }
            // System.out.println(String.format("n lower than zero", n, answer));
            n = (-1) * n;

            x = 1.0 / x;
        }
        // System.out.println(String.format("x: %f, n: %d", x, n));
        for (int i = 0; i < n / 4; i++) {
            answer *= x;
            if (answer == 0) {
                return 0.0;
            }
        }
        switch (n % 4) {
            case 0:
                return answer * answer * answer * answer;
            case 1:
                return answer * answer * answer * answer * x;
            case 2:
                return answer * answer * answer * answer * x * x;
            case 3:
                return answer * answer * answer * answer * x * x * x;
        }
        return 0;
    }

}
