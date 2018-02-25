package com.getadhell.leetcode.P204;

/**
 * https://leetcode.com/problems/count-primes/description/
 */
public class Solution {
    public int countPrimes(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return 0;
        }
        boolean[] notPrime = new boolean[n];
        notPrime[0] = notPrime[1] = true;
        int p = 2;
        while (true) {
            for (int i = 2 * p; i < n; i += p) {
                notPrime[i] = true;
            }
            for (int i = p + 1; i < n; i++) {
                if (!notPrime[i]) {
                    p = i;
                    break;
                }
            }
            if (p * p > n) {
                break;
            }
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (!notPrime[i]) {
                answer++;
            }
        }
        return answer;
    }
}
