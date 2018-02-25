package com.getadhell.leetcode.P171;

/**
 * https://leetcode.com/problems/excel-sheet-column-number/description/
 */
public class Solution {
    public int titleToNumber(String s) {
        int answer = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            answer += (int) Math.pow(26, (s.length() - (i + 1))) * (int) (s.charAt(i) - 'A' + 1);
        }
        return answer;
    }
}
