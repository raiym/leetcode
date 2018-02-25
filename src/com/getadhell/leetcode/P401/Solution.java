package com.getadhell.leetcode.P401;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-watch/description/
 */
public class Solution {
    private static int getSetBitsNum(int num) {
        int count = 0;
        while (num != 0) {
            num &= num - 1;
            count++;
        }
        return count;
    }

    public List<String> readBinaryWatch(int num) {
        List<String> answer = new ArrayList<String>();
        int n = 0;
        while (n < 1024) {
            if (getSetBitsNum(n) != num) {
                n++;
                continue;
            }

            int hours = n >>> 6;
            int mins = n & 63;
            if (hours < 12 && mins < 60) {
                if (mins < 10) {
                    answer.add(hours + ":0" + mins);
                } else {
                    answer.add(hours + ":" + mins);
                }
            }
            n++;
        }
        return answer;
    }
}
