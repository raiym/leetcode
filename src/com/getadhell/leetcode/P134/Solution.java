package com.getadhell.leetcode.P134;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/gas-station/description/
 */

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] step = new int[gas.length];
        int gasSum = 0;
        Set<Integer> indexes = new HashSet<>();
        int sum = 0;
        for (int i = 0; i < step.length; i++) {
            step[i] = gas[i] - cost[i];
            gasSum += step[i];
            if (step[i] < 0) {
                if (indexes.size() == 0) {
                    indexes.add((i + 1) % step.length);
                } else {
                    if (sum - step[i] >= 0) {
                        indexes.add((i + 1) % step.length);
                    }
                }
                sum = 0;
                continue;
            }
            sum += step[i];

        }
        if (gasSum < 0) {
            return -1;
        }
        if (indexes.size() == 0) {
            return 0;
        }
        for (Integer i : indexes) {
            int tank = 0;
            for (int j = 0; j < step.length; j++) {
                int index = (i + j) % step.length;
                tank += step[index];
                if (tank < 0) {
                    break;
                }
            }
            if (tank >= 0) {
                return i;
            }
        }
        return -1;
    }
}
