package com.getadhell.leetcode.P322;

/**
 * https://leetcode.com/problems/coin-change/description/
 */
class Solution {
    public int coinChange(int[] coins, int amount) {

        int[] values = new int[amount + 1];
        return coin(coins, amount, values);
    }


    public int coin(int[] coins, int amount, int[] values) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (values[amount] != 0) {
            return values[amount];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int number = coin(coins, amount - coin, values);
            if (number < min && number != -1) {
                min = number + 1;
            }
        }

        if (min == Integer.MAX_VALUE) {
            values[amount] = -1;
        } else {
            values[amount] = min;
        }

        return values[amount];
    }

}
