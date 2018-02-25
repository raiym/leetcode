package com.getadhell.leetcode.P118;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle/description/
 */
public class Solution {
    private static List<List<Integer>> listList = new ArrayList<>();

    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return listList;
        }
        if (listList.size() == 0) {
            List<Integer> one = new ArrayList<Integer>();
            one.add(1);
            listList.add(one);
        }
        if (numRows == 1) {
            return listList;
        }
        if (listList.size() >= numRows) {
            List<List<Integer>> l = listList.subList(0, numRows);
            return l;
        } else {
            int listSize = listList.size();
            for (int i = listSize; i < numRows; i++) {
                Integer[] row = new Integer[i + 1];
                row[0] = row[row.length - 1] = 1;
                List<Integer> m = listList.get(i - 1);
                for (int j = 1; j <= i / 2; j++) {
                    int sum = m.get(j - 1) + m.get(j);
                    row[j] = row[row.length - 1 - j] = sum;
                }
                List<Integer> arr = Arrays.asList(row);
                listList.add(arr);
            }
            return listList;
        }

    }
}