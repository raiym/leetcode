package com.getadhell.leetcode.P34;

/**
 * https://leetcode.com/problems/search-for-a-range/description/
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int index = getIndex(nums, target, 0, nums.length - 1);
        if (index == -1) {
            System.out.println("Index return -1");
            int[] ar = {-1, -1};
            return ar;
        }
        int start = index;
        int end = index;
        while (start >= 0 && nums[start] == nums[end]) {
            start--;
        }
        start++;
        while (end <= nums.length - 1 && nums[start] == nums[end]) {
            end++;
        }
        end--;
        int[] ar = new int[]{start, end};
        return ar;

    }

    private int getIndex(int[] nums, int target, int start, int end) {
        if (start > end) {
            System.out.println("start > end");
            return -1;
        }
        int ind = (start + end) / 2;
        if (nums[ind] == target) {
            return ind;
        } else if (nums[ind] > target) {
            return getIndex(nums, target, start, ind - 1);
        } else {
            return getIndex(nums, target, ind + 1, end);
        }
    }
}
