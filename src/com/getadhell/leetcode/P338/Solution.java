package com.getadhell.leetcode.P338;

/**
 * https://leetcode.com/problems/counting-bits/description/
 */
public class Solution {
    public int[] countBits(int num) {
        int[] bits = new int[num + 1];
        int cursor = 4;
        bits[0] = 0;
        if (num == 0) {
            return bits;
        }
        bits[1] = 1;
        if (num == 1) {
            return bits;
        }
        bits[2] = 1;
        if (num == 2) {
            return bits;
        }
        bits[3] = 2;
        if (num == 3) {
            return bits;
        }
        for (int i = 4; i < 2 * (num + 1); i *= 2) {
            calc(bits, i);
        }
        return bits;
    }

    public void calc(int[] bits, int startIndex) {
        int cursor = startIndex / 2;
        int limit = startIndex;
        while (cursor != limit) {
            if (startIndex >= bits.length) {
                break;
            }
            bits[startIndex] = bits[cursor];
            if (startIndex + 1 >= bits.length) {
                break;
            }
            bits[startIndex + 1] = bits[cursor] + 1;
            startIndex += 2;
            cursor++;
        }
    }

}