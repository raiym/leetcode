package com.getadhell.leetcode.P88;

/**
 * https://leetcode.com/problems/merge-sorted-array/description/
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mIndex = m - 1;
        int nIndex = n - 1;
        int cursor = nums1.length - 1;
        while (nIndex >= 0) {
            if (mIndex >= 0 && nums1[mIndex] > nums2[nIndex]) {
                nums1[cursor] = nums1[mIndex];
                mIndex--;
            } else {
                nums1[cursor] = nums2[nIndex];
                nIndex--;
            }
            cursor--;
        }
    }
}
