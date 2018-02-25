package com.getadhell.leetcode.P78;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/description/
 */
public class Solution {
    private List<List<Integer>> answer;

    public List<List<Integer>> subsets(int[] nums) {
        answer = new ArrayList<>();
        for (int i = 0; i < nums.length + 1; i++) {
            generate(nums, i, 0, new ArrayList<>());
        }
        return answer;
    }

    private void generate(int[] nums, int size, int index, List<Integer> list) {
        if (size == 0) {
            answer.add(list);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            List<Integer> l = new ArrayList<>(list);
            l.add(nums[i]);
            generate(nums, size - 1, i + 1, l);
        }
    }
}