package com.getadhell.leetcode.P122;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int balance = 0;
        boolean own = false;
        for (int i = 0; i < prices.length - 1; i++) {
            if (!own && prices[i] < prices[i + 1]) {
                own = true;
                balance -= prices[i];
            }
            if (own && prices[i] > prices[i + 1]) {
                own = false;
                balance += prices[i];
            }
        }
        if (own) {
            balance += prices[prices.length - 1];
        }
        return balance;
    }
}
