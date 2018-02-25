package com.getadhell.leetcode.P11;

/**
 * https://leetcode.com/problems/container-with-most-water/description/
 */
public class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int i = 0;
        int j = height.length - 1;
        int line = height.length - 1;
        while (line > 0) {
            int s;
            if (height[i] < height[j]) {
                s = height[i] * line;
                i++;
            } else {
                s = height[j] * line;
                j--;
            }
            line--;
            if (s > max) {
                max = s;
            }
        }
        return max;
    }
}
