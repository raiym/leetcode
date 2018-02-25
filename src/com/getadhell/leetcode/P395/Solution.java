package com.getadhell.leetcode.P395;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/description/
 */
public class Solution {
    public int longestSubstring(String s, int k) {
        if (k == 0 || k == 1) {
            return s.length();
        }

        List<Integer> numbers = new ArrayList<>();
        numbers.add(-1);
        numbers.add(s.length());
        calc(numbers, s, -1, s.length(), k);
        System.out.println(numbers);
        int answer = 0;
        for (int i = 1; i < numbers.size(); i++) {
            int n = numbers.get(i) - numbers.get(i - 1) - 1;
            int p = numbers.get(i - 1) + 1;
            int q = numbers.get(i) - 1;
            int[] a = new int[26];
            for (int j = p; j <= q; j++) {
                a[s.charAt(j) - 97]++;
                // System.out.print(s.charAt(j) + " |");
            }
            // System.out.println();

            boolean isExist = true;
            for (int j = 0; j < 26; j++) {
                if (a[j] != 0 && a[j] < k) {
                    isExist = false;
                    break;
                }
            }
            if (isExist && n > answer) {
                answer = n;
            }
        }
        return answer;
    }

    private void calc(List<Integer> numbers, String s, int p, int q, int k) {
        LinkedList<Integer>[] alphabet = new LinkedList[26];
        for (int i = p + 1; i <= q - 1; i++) {
            if (alphabet[s.charAt(i) - 97] == null) {
                alphabet[s.charAt(i) - 97] = new LinkedList<Integer>();
            }
            alphabet[s.charAt(i) - 97].add(i);
        }
        int added = 0;
        int ad = 0;
        for (LinkedList<Integer> anAlphabet : alphabet) {
            added += ((anAlphabet != null) ? anAlphabet.size() : 0);
            if (anAlphabet != null && anAlphabet.size() != 0 && anAlphabet.size() < k) {
                numbers.addAll(anAlphabet);

                // System.out.println(alphabet[i]);
            } else if (anAlphabet != null) {
                ad += anAlphabet.size();
            }
        }
        // System.out.println(added);
        if (added == 0 || ad == added) {
            return;
        }
        Collections.sort(numbers);
        for (int i = 1; i < numbers.size(); i++) {
            calc(numbers, s, numbers.get(i - 1), numbers.get(i), k);
        }
    }
}