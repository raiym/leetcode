package com.getadhell.leetcode.P387;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/first-unique-character-in-a-string/description/
 */
public class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> positionMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
                positionMap.put(s.charAt(i), i);
            }
        }
        int position = Integer.MAX_VALUE;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                int pos = positionMap.get(entry.getKey());
                if (pos < position) {
                    position = pos;
                }
            }
        }
        if (position == Integer.MAX_VALUE) {
            return -1;
        }
        return position;
    }
}
