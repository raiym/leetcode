package com.getadhell.leetcode.P779;

/**
 * https://leetcode.com/contest/weekly-contest-70/problems/k-th-symbol-in-grammar/
 */
class Solution {
    public int kthGrammar(int N, int K) {
        K--;
        int pow = 1;
        while (pow < K) {
            pow *= 2;
        }
        pow /= 2;
        boolean flag = true;
        while (K > 2) {
            K = K % pow;
            while (pow > K) {
                pow /= 2;
            }

            flag = !flag;
        }
        if (K == 0) {
            if (flag) {
                return 0;
            }
            return 1;
        } else {
            if (flag) {
                return 1;
            }
            return 0;
        }
    }
}
