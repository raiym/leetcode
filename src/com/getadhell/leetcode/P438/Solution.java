package com.getadhell.leetcode.P438;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 */
public class Solution {

    public static List<Integer> findAnagrams(String s, String p) {
        int pLength = p.length();
        if (s == null || s.length() < pLength) {
            return new ArrayList<>();
        }
        int[] a = new int[26];
        for (int i = 0; i < p.length(); i++) {
            a[p.charAt(i) - 97]++;
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int j = 0; j < s.length(); j++) {
            if (s.length() - j < p.length()) {
                break;
            }
            List<Integer> values = check(s, a, j, p);
            if (values != null) {
                list.addAll(values);
                j += values.size();
            }
        }
        return list;
    }

    private static List<Integer> check(String s, int[] map, int index, String p) {
        int pLength = p.length();
        map = map.clone();
        for (int i = index; i < s.length() && i < index + pLength; i++) {
            if (map[s.charAt(i) - 97] == 0) {
                break;
            }
            map[s.charAt(i) - 97]--;
        }
        boolean isAnswered = true;
        for (int i = 0; i < map.length; i++) {
            if (map[i] != 0) {
                isAnswered = false;
                break;
            }
        }

        if (!isAnswered) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        list.add(index);
        while ((index + pLength < s.length()) && s.charAt(index) == s.charAt(index + pLength)) {
            index++;
            list.add(index);
        }
        return list;
    }
}
