package com.getadhell.leetcode.P46;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/description/
 */
public class Solution {

    List<List<Integer>> listList;
    private boolean[] used;
    private int size;

    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        listList = new ArrayList<>();
        this.size = nums.length;
        go(nums, new ArrayList<Integer>());
        return listList;
    }

    private void go(int[] nums, List<Integer> list) {
        if (list.size() == this.size) {
            listList.add(list);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            List<Integer> l = new ArrayList<Integer>(list);
            l.add(nums[i]);
            used[i] = true;
            go(nums, l);
            used[i] = false;
        }
    }
}
