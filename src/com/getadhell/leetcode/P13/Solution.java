package com.getadhell.leetcode.P13;

/**
 * https://leetcode.com/problems/roman-to-integer/description/
 */
public class Solution {
    public int romanToInt(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int answer = charToInt(s.charAt(s.length() - 1));
        int next = answer;
        for (int i = s.length() - 2; i >= 0; i--) {
            int current = charToInt(s.charAt(i));
            if (current < next) {
                answer -= current;
            } else {
                answer += current;
            }
            next = current;

        }
        return answer;

    }

    public int charToInt(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }
}
