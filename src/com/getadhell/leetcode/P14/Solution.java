package com.getadhell.leetcode.P14;

/**
 * https://leetcode.com/problems/longest-common-prefix/description/
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = "";
        while (true) {
            for (String word : strs) {
                if (!word.startsWith(prefix)) {
                    return prefix.substring(0, prefix.length() - 1);
                }
            }
            if (prefix.length() == strs[0].length()) {
                return prefix;
            }
            prefix += strs[0].charAt(prefix.length());
        }
    }
}
