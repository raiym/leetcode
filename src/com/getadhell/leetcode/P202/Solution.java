package com.getadhell.leetcode.P202;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/happy-number/description/
 */
public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer>();
        int m = 0;
        set.add(n);
        while (true) {
            while (n > 0) {
                m += ((n % 10) * (n % 10));
                n /= 10;
            }
            if (m == 1) {
                return true;
            } else if (set.contains(m)) {
                return false;
            }
            set.add(m);
            n = m;
            m = 0;
        }
    }
}
