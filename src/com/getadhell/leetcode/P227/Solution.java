package com.getadhell.leetcode.P227;

/**
 * https://leetcode.com/problems/basic-calculator-ii/description/
 */
class Solution {
    public int calculate(String s) {
        String[] sums = s.split("\\+");
        int answer = 0;
        int sub;
        for (String part : sums) {
            String[] parts = part.split("-");
            sub = justDoIt(parts[0]);
            for (int j = 1; j < parts.length; j++) {
                sub -= justDoIt(parts[j]);
            }
            answer += sub;
        }
        return answer;

    }


    int justDoIt(String s) {
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '*') {
                return (justDoIt(s.substring(0, i)) * Integer.parseInt(s.substring(i + 1, s.length()).trim()));
            } else if (s.charAt(i) == '/') {
                return (justDoIt(s.substring(0, i)) / Integer.parseInt(s.substring(i + 1, s.length()).trim()));
            }
        }
        return Integer.parseInt(s.trim());
    }
}
