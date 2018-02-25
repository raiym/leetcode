package com.getadhell.leetcode.P125;

/**
 * https://leetcode.com/problems/valid-palindrome/description/
 */
public class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return true;
        }
        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {
            while (!isAlphaNumeric(s.charAt(start))) {
                start++;
                if (start == end) {
                    return true;
                }
            }
            while (!isAlphaNumeric(s.charAt(end))) {
                end--;
                if (start == end) {
                    return true;
                }
            }
            if (!isEqual(s.charAt(start), s.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private static boolean isAlphaNumeric(char c) {
        if ((65 <= c && c <= 90 )
                || (97 <= c && c <= 122)
                || (48 <= c && c <= 57)) {
            return true;
        }
        return false;
    }

    private static boolean isEqual(char a, char b) {
        if (a == b) {
            return true;
        }
        if ( Math.abs(a - b) == 32) {
            if ((48 <= a && a <= 57) || (48 <= b && b <= 57)) {
                return false;
            }
            return true;
        }
        return false;
    }
}
