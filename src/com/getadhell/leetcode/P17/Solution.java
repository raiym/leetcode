package com.getadhell.leetcode.P17;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 */
public class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<String>();
        }
        List<String> list = new ArrayList<String>();
        calc(list, digits, "");
        return list;
    }

    private void calc(List<String> list, String digits, String word) {
        if (word.length() == digits.length()) {
            list.add(word);
            return;
        }
        char c = digits.charAt(word.length());
        char[] letters = getDigits(c);
        for (char letter : letters) {
            calc(list, digits, word + letter);
        }
    }

    private char[] getDigits(char digit) {
        char[] s;
        switch (digit) {
            case '1':
                return null;
            case '2':
                s = new char[3];
                s[0] = 'a';
                s[1] = 'b';
                s[2] = 'c';
                return s;
            case '3':
                s = new char[3];
                s[0] = 'd';
                s[1] = 'e';
                s[2] = 'f';
                return s;
            case '4':
                s = new char[3];
                s[0] = 'g';
                s[1] = 'h';
                s[2] = 'i';
                return s;
            case '5':
                s = new char[3];
                s[0] = 'j';
                s[1] = 'k';
                s[2] = 'l';
                return s;
            case '6':
                s = new char[3];
                s[0] = 'm';
                s[1] = 'n';
                s[2] = 'o';
                return s;
            case '7':
                s = new char[4];
                s[0] = 'p';
                s[1] = 'q';
                s[2] = 'r';
                s[3] = 's';
                return s;
            case '8':
                s = new char[3];
                s[0] = 't';
                s[1] = 'u';
                s[2] = 'v';
                return s;
            case '9':
                s = new char[4];
                s[0] = 'w';
                s[1] = 'x';
                s[2] = 'y';
                s[3] = 'z';
                return s;
            case '0':
                return null;
        }
        return null;
    }
}
