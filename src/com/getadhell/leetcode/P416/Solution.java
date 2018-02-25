package com.getadhell.leetcode.P416;

/**
 * https://leetcode.com/problems/partition-equal-subset-sum/description/
 */
public class Solution {
    public boolean canPartition(int[] nums) {
        if (nums.length == 0) {
            return true;
        }
        int sum = getSum(nums);
        if (sum % 2 != 0) {
            return false;
        }
        sum /= 2;
        boolean[] isSum = new boolean[sum + 1];
        isSum[0] = true;
        boolean[] isSkip;
        for (int num : nums) {
            isSkip = new boolean[sum + 1];
            for (int j = 0; j < sum + 1; j++) {
                if (!isSkip[j] && isSum[j] && (j + num < sum + 1)) {
                    if (!isSum[j + num]) {
                        isSkip[j + num] = true;
                    }

                    isSum[j + num] = true;
                }
            }
        }
        return isSum[sum];
    }

    private int getSum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
