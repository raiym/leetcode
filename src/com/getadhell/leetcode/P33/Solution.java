package com.getadhell.leetcode.P33;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 */
public class Solution {
    public int search(int[] nums, int target) {
        int index = 0;
        int i = 0;
        int j = nums.length - 1;
        if (j >= 0 && nums[j] == target) {
            return j;
        }

        int tries = 0;
        while (tries < nums.length) {
            index = (i + j) / 2;
            if (nums[index] == target) {
                break;
            } else if (target < nums[index]) {
                if (nums[i] > target) {
                    if (nums[i] > nums[index]) {
                        j = index;
                    } else {
                        i = index;
                    }
                } else {
                    j = index;
                }
            } else if (nums[index] < target) {
                if (nums[j] < target) {
                    if (nums[index] > nums[j]) {
                        i = index;
                    } else {
                        j = index;
                    }

                } else {
                    i = index;
                }
            }
            tries++;
        }
        if (tries >= nums.length || nums[index] != target) {
            return -1;
        }
        return index;
    }
}