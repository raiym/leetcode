package com.getadhell.leetcode.P242;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/valid-anagram/description/
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        for (int i = 0; i < tArr.length; i++) {
            if (tArr[i] != sArr[i]) {
                return false;
            }
        }
        return true;
    }
}