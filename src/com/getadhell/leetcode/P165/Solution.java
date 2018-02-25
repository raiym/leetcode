package com.getadhell.leetcode.P165;

/**
 * https://leetcode.com/problems/compare-version-numbers/description/
 */
public class Solution {
    public static int compareVersion(String version1, String version2) {
        String[] parts1 = version1.split("\\.");
        String[] parts2 = version2.split("\\.");

        if (version1.length() == 1) {
            parts1 = new String[1];
            parts1[0] = version1;
        }
        if (version2.length() == 1) {
            parts2 = new String[1];
            parts2[0] = version2;
        }

        int index = 0;
        while (true) {
            if (index >= parts1.length && index >= parts2.length) {
                return 0;
            }
            int a = 0;
            int b = 0;

            if (index < parts1.length) {
                a = Integer.parseInt(parts1[index]);
            }
            if (index < parts2.length) {
                b = Integer.parseInt(parts2[index]);
            }

            if (a > b) {
                return 1;
            } else if (a == b) {
                index++;
                continue;
            } else {
                return -1;
            }
        }
    }
}