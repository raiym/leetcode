package com.getadhell.leetcode.P139;

import java.util.*;

/**
 * https://leetcode.com/problems/word-break/description/
 */
public class Solution {
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<Integer> was = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int index = queue.poll();
            if (was.contains(index)) {
                continue;
            }
            if (index == s.length()) {
                return true;
            }
            int numberOfAdditions = 0;
            for (String word : wordDict) {
                if (index + word.length() > s.length()) {
                    continue;
                }
                String toCheck = s.substring(index, index + word.length());
                if (toCheck.equals(word)) {
                    numberOfAdditions++;
                    queue.offer(index + word.length());
                }
            }
            was.add(index);
        }
        return false;
    }
}