package com.getadhell.leetcode.P392;

/**
 * https://leetcode.com/problems/is-subsequence/description/
 */
public class Solution {
    public boolean isSubsequence(String s, String t) {
        int first = 0;
        for (int index = 0; index < s.length(); index++) {
            first = t.indexOf(s.charAt(index), first);
            if (first == -1) {
                return false;
            }
            first++;
        }
        return true;
    }
}
