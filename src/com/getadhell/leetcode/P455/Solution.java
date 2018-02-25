package com.getadhell.leetcode.P455;

/**
 * https://leetcode.com/problems/assign-cookies/description/
 */
public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        quicksort(g, 0, g.length - 1);
        quicksort(s, 0, s.length - 1);
        int number = 0;
        int j = 0;
        for (int i = 0; i < g.length; i++) {
            while (true) {
                if (j == s.length) {
                    return number;
                }
                if (g[i] <= s[j]) {
                    number++;
                    j++;
                    break;
                }
                j++;
            }
        }
        return number;
    }

    public void quicksort(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        int partIndex = partition(a, start, end);
        quicksort(a, start, partIndex - 1);
        quicksort(a, partIndex + 1, end);
    }

    public int partition(int[] a, int start, int end) {
        int i = start;
        int j = start;
        while (i < end) {
            if (a[i] < a[end]) {
                swap(a, i, j);
                j++;
            }
            i++;
        }
        swap(a, end, j);
        return j;
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}