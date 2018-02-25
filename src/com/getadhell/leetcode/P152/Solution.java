package com.getadhell.leetcode.P152;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/maximum-product-subarray/description/
 */
class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        List<Integer> zeros = new ArrayList<>();
        List<Integer> minusOnes = new ArrayList<>();
        int max = nums[0];
        zeros.add(-1);
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
            if (nums[i] == 0) {
                zeros.add(i);
            }
            if (nums[i] == -1) {
                minusOnes.add(i);
            }
        }
        zeros.add(nums.length);
        for (int i = 0; i < zeros.size() - 1; i++) {
            int start = zeros.get(i) + 1;
            int end = zeros.get(i + 1) - 1;
            if (start > end) {
                continue;
            }
            int numberOfMinuses = 0;
            int firstMinus = -1;
            int lastMinus = -1;
            int curProduct = 1;
            // System.out.println("Start: " + zeros.get(i) + " End: " + zeros.get(i + 1));
            for (int j = start; j <= end; j++) {
                curProduct *= nums[j];
                if (nums[j] < 0) {
                    numberOfMinuses++;
                    if (firstMinus == -1) {
                        firstMinus = j;
                    }
                    lastMinus = j;
                }
            }
            if (numberOfMinuses % 2 == 0) {
                if (max < curProduct) {
                    max = curProduct;
                }
            } else {
                if (numberOfMinuses == 1) {
                    curProduct = nums[start];
                    // System.out.println("CurProduct: " + curProduct);
                    for (int j = start + 1; j < firstMinus; j++) {
                        curProduct *= nums[j];
                    }
                    if (max < curProduct) {
                        max = curProduct;
                    }
                    curProduct = nums[end];
                    // System.out.println("CurProduct: " + curProduct);
                    for (int j = firstMinus + 1; j < end; j++) {
                        curProduct *= nums[j];
                    }
                    // System.out.println("max: " + max);
                    if (max < curProduct) {
                        max = curProduct;
                    }
                } else {
                    curProduct = 1;
                    for (int j = start; j < lastMinus; j++) {
                        curProduct *= nums[j];
                    }
                    if (max < curProduct) {
                        max = curProduct;
                    }
                    curProduct = 1;
                    for (int j = firstMinus + 1; j <= end; j++) {
                        curProduct *= nums[j];
                    }
                    if (max < curProduct) {
                        max = curProduct;
                    }
                }
            }
        }
        return max;
    }
}
