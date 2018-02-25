package com.getadhell.leetcode.P405;

/**
 * https://leetcode.com/problems/convert-a-number-to-hexadecimal/description/
 */
public class Solution {
    private String[] bits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        String answer = "";
        while (num != 0) {
            answer = bits[num & 15] + answer;
            num >>>= 4;
        }
        return answer;
    }
}
