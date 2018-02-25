package com.getadhell.leetcode.P350;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
 */
public class Solution {
    public static int[] convertIntegers(List<Integer> integers) {
        int[] ret = new int[integers.size()];
        Iterator<Integer> iterator = integers.iterator();
        for (int i = 0; i < ret.length; i++) {
            ret[i] = iterator.next().intValue();
        }
        return ret;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums2);
        Arrays.sort(nums1);
        return calc(nums1, nums2);
    }

    public int[] calc(int[] a, int[] b) {
        List<Integer> list = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = index; j < b.length; j++) {
                if (a[i] < b[j]) {
                    break;
                }
                if (a[i] == b[j]) {
                    list.add(a[i]);
                    index++;
                    break;
                }
                index++;
            }
        }
        return convertIntegers(list);
    }
}