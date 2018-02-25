package com.getadhell.leetcode.P344;

/**
 * https://leetcode.com/problems/reverse-string/description/
 */
public class Solution {
    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        int i = s.length() - 1;
        int j = 0;
        while (i > j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i--;
            j++;

        }
        return new String(chars);
    }
}