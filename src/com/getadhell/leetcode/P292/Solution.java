package com.getadhell.leetcode.P292;

/**
 * https://leetcode.com/problems/nim-game/description/
 */
public class Solution {
    public boolean canWinNim(int n) {
        return !(n % 4 == 0);
    }
}