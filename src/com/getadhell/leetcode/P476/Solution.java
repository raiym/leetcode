package com.getadhell.leetcode.P476;

/**
 * https://leetcode.com/problems/number-complement/description/
 */
public class Solution {
    public int findComplement(int num) {
        int cursor = 1;
        int i = 31;
        while (((num & (cursor << i)) >> i) == 0) {
            i--;
            cursor = 1;
        }
        int answer = 0;
        for (int j = i; j >= 0; j--) {
            cursor = 1;
            if (((num & (cursor << j)) >> j) == 0) {
                answer ^= (cursor << j);
            }
        }
        return answer;
    }
}