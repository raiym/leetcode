package com.getadhell.leetcode.P5;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 */
public class Solution {
    private static int[] lastIndex(String s, int p, int q) {
        while (p >= 0 && q < s.length() && p < s.length() - 1 && q >= 0 && s.charAt(p) == s.charAt(q)) {
            p--;
            q++;
        }
        int[] ar = new int[2];
        ar[0] = p + 1;
        ar[1] = q - 1;
        return ar;
    }

    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] a = lastIndex(s, i, i);
            if (a[1] - a[0] > endIndex - startIndex) {
                startIndex = a[0];
                endIndex = a[1];
            }
            a = lastIndex(s, i, i + 1);
            if (a[1] - a[0] > endIndex - startIndex) {
                startIndex = a[0];
                endIndex = a[1];
            }
        }
        return s.substring(startIndex, endIndex + 1);
    }
}