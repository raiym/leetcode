package com.getadhell.leetcode.P384;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/shuffle-an-array/description/
 */
public class Solution {
    private Integer[] nums;
    private int[] nums2;

    public Solution(int[] nums) {
        this.nums = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            this.nums[i] = nums[i];
        }
        this.nums2 = nums;
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return this.nums2;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        List<Integer> list = new LinkedList<Integer>(Arrays.asList(this.nums));
        int[] ar = new int[this.nums.length];
        for (int i = 0; i < this.nums.length; i++) {
            int index = (int) (Math.random() * list.size());
            ar[i] = list.get(index);
            list.remove(index);
        }
        return ar;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */