package com.getadhell.leetcode.P169;

/**
 * https://leetcode.com/problems/majority-element/description/
 */
public class Solution {
    public int majorityElement(int[] nums) {
        int elementIndex = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                elementIndex = i;
                count++;
            } else if (nums[elementIndex] == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return nums[elementIndex];
    }
}
