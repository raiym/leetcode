package com.getadhell.leetcode.P49;

/**
 * https://leetcode.com/problems/group-anagrams/description/
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        String[] strs = new String[]{"cab", "tin", "pew", "lli", "may", "ill", "buy", "bar", "max", "doc"};
        new Solution().groupAnagrams(strs);
    }

    private static String getKey(String s) {
        char[] row = new char[26];
        for (int i = 0; i < s.length(); i++) {
            row[s.charAt(i) - 'a']++;
        }
        return new String(row);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answer = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String key = getKey(str);
            List<String> list = map.get(key);
            if (list == null) {
                list = new ArrayList<String>();
                list.add(str);
                map.put(key, list);
            } else {
                list.add(str);
            }

        }
        answer.addAll(map.values());
        // System.out.println(answer);
        return answer;

    }
}
