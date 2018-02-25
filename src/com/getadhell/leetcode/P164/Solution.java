package com.getadhell.leetcode.P164;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/maximum-gap/description/
 */
public class Solution {
    public int maximumGap(int[] nums) {
        LinkedList<Integer>[] linkedListArray = new LinkedList[10];
        for (int i = 0; i < 10; i++) {
            linkedListArray[i] = new LinkedList<Integer>();
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        int m = 10;
        int n = 1;
        while (max > 0) {
            for (int i = 0; i < nums.length; i++) {
                int number = (nums[i] % m) / n;
                linkedListArray[number].add(nums[i]);
            }
            int index = 0;
            for (int i = 0; i < 10; i++) {
                while (!linkedListArray[i].isEmpty()) {
                    nums[index] = linkedListArray[i].remove();
                    index++;
                }
            }
            m *= 10;
            n *= 10;
            max /= 10;
        }
        int maxDiff = 0;
        for (int i = 1; i < nums.length; i++) {
            int k = nums[i] - nums[i - 1];
            if (k > maxDiff) {
                maxDiff = k;
            }
        }
        return maxDiff;
    }
}
