package com.getadhell.leetcode.P345;

/**
 * https://leetcode.com/problems/reverse-vowels-of-a-string/description/
 */
public class Solution {
    private static boolean isVowel(char c) {
        switch (c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                return true;
        }
        return false;
    }

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int i = chars.length - 1;
        int j = 0;
        while (i > j) {
            if (!isVowel(chars[i])) {
                i--;
            }
            if (!isVowel(chars[j])) {
                j++;
            }
            if (isVowel(chars[i]) && isVowel(chars[j])) {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i--;
                j++;
            }
        }
        return new String(chars);
    }
}
