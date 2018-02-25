package com.getadhell.leetcode.P295;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-median-from-data-stream/description/
 */
public class MedianFinder {
    List<Integer> list;

    public MedianFinder() {
        list = new ArrayList<Integer>();
    }

    // Adds a number into the data structure.
    public void addNum(int num) {
        for (int i = 0; i < list.size(); i++) {
            if (num < list.get(i)) {
                list.add(i, num);
                return;
            }
        }
        list.add(num);
    }

    // Returns the median of current data stream
    public double findMedian() {
        int index = list.size() / 2;
        if (list.size() % 2 == 0) {
            return (double) (list.get(index) + list.get(index - 1)) / 2.0;
        } else {
            return (double) list.get(index);
        }
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();