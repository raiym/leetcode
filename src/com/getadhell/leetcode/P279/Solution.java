package com.getadhell.leetcode.P279;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/perfect-squares/description/
 */
public class Solution {
    private static List<Integer> list = new ArrayList<Integer>();

    private static boolean isSquare(int candidate) {
        for (int i = 0; i * i <= candidate; i++) {
            if (i * i == candidate) {
                return true;
            }
        }
        return false;
    }

    public int numSquares(int n) {
        if (list.size() == 0) {
            list.add(1);
        }
        if (n < list.size()) {
            return list.get(n);
        }
        for (int i = list.size(); i <= n; i++) {
            if (isSquare(i)) {
                list.add(1);
                continue;
            }
            int number = Integer.MAX_VALUE;
            for (int j = 1; j < i / 2 + 1; j++) {
                int candidate = list.get(i - j) + list.get(j);
                if (candidate < number) {
                    number = candidate;
                }
            }
            list.add(number);
        }
        System.out.println(list);
        return list.get(n);
    }
}
