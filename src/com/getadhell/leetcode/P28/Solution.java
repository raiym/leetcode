package com.getadhell.leetcode.P28;

/**
 * https://leetcode.com/problems/implement-strstr/description/
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int needleIndex = 0;
            int start = i;
            int end = i + needle.length() - 1;
            boolean isExist = true;
            while (start <= end) {
                if (haystack.charAt(start) == needle.charAt(needleIndex)
                        && haystack.charAt(end) == needle.charAt(needle.length() - 1 - needleIndex)) {

                } else {
                    isExist = false;
                    break;
                }
                start++;
                end--;
                needleIndex++;
            }
            if (isExist) {
                return i;
            }
        }
        return -1;
    }
}
