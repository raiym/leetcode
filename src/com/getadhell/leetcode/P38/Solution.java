package com.getadhell.leetcode.P38;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/count-and-say/description/
 */
public class Solution {

    private static List<String> list = new ArrayList<>();

    private static String generateWord(String word) {
        StringBuilder answer = new StringBuilder();
        int number = 1;
        char c = word.charAt(0);
        for (int i = 1; i < word.length(); i++) {
            if (c == word.charAt(i)) {
                number++;
            } else {
                answer.append(number);
                answer.append(c);
                c = word.charAt(i);
                number = 1;
            }
        }
        answer.append(number);
        answer.append(c);
        return answer.toString();
    }

    public String countAndSay(int n) {
        if (n == 0) {
            return null;
        }
        n--;
        if (list.size() == 0) {
            list.add("1");
            list.add("11");
        }

        if (n < list.size()) {
            return list.get(n);
        }
        int freezeIndex = list.size() - 1;
        for (int i = freezeIndex; i <= n; i++) {
            String to = list.get(i);
            String word = generateWord(to);
            list.add(word);
        }
        System.out.println(list);
        return list.get(n);
    }
}
