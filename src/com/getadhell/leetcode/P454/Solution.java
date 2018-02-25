package com.getadhell.leetcode.P454;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/4sum-ii/description/
 */
public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int[] first = new int[A.length * B.length];
        int index = 0;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                map.put(A[i] + B[j], map.getOrDefault(A[i] + B[j], 0) + 1);
                index++;
            }
        }
        index = 0;
        int[] second = new int[C.length * D.length];
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int opposite = -(C[i] + D[j]);
                if (map.containsKey(opposite)) {
                    // set.remove(opposite);
                    index += map.get(opposite);
                }
            }
        }
        return index;
    }

    private void printArr(int[] a) {
        System.out.println("--start arr--");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.println("--end arr--");
    }
}