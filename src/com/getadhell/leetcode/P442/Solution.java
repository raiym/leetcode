package com.getadhell.leetcode.P442;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
 */
public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> array = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0) {
                nums[val] = -nums[val];
            } else {
                array.add(val + 1);
            }
        }
        return array;
    }
}