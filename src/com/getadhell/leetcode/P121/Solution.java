package com.getadhell.leetcode.P121;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 */
public class Solution {
    private static int min(int a, int b) {
        return a < b ? a : b;
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int min = min(prices[1], prices[0]);
        int max = prices[1] - prices[0];
        for (int i = 2; i < prices.length; i++) {
            if (prices[i] - min > max) {
                max = prices[i] - min;
            }
            min = min(prices[i], min);
        }
        if (max < 0) {
            return 0;
        }
        return max;

    }
}
