package com.getadhell.leetcode.P215;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    public void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int index = partition(nums, start, end);
        quickSort(nums, start, index - 1);
        quickSort(nums, index + 1, end);
    }

    public int partition(int[] a, int start, int end) {
        int i = start;
        int j = start;
        while (j < end) {
            if (a[j] < a[end]) {
                int t = a[j];
                a[j] = a[i];
                a[i] = t;
                i++;
            }
            j++;
        }
        if (a[i] > a[end]) {
            int t = a[i];
            a[i] = a[end];
            a[end] = t;
        }
        return i;
    }


}
