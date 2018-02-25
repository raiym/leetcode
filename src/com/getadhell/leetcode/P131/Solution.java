package com.getadhell.leetcode.P131;

/**
 * https://leetcode.com/problems/palindrome-partitioning/description/
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {

    int index;
    private String word;
    private int wordLength;
    private List<Integer>[] par;
    private List<List<String>> answer;

    public static void main(String[] args) {
        Solution s = new Solution();
        s.init("lolol");
        s.calc();
        s.generate(0, new ArrayList<String>());
        System.out.println(s.answer);
    }

    private void generate(int currentLength, List<String> parts) {
        if (currentLength == wordLength) {
            answer.add(parts);
            return;
        }
        for (Integer i : par[currentLength]) {
            List<String> l = new ArrayList<>(parts);
            l.add(word.substring(currentLength, currentLength + i));
            generate(currentLength + i, l);
        }
    }

    private void init(String s) {
        word = s;
        wordLength = word.length();
        this.par = new ArrayList[this.wordLength];
        index = this.par.length - 1;
        answer = new ArrayList<>();
    }

    public List<List<String>> partition(String s) {
        init(s);
        calc();
        generate(0, new ArrayList<String>());
        return answer;
    }

    private void calc() {
        while (index >= 0) {
            for (int i = index; i < this.wordLength; i++) {
                if (isPalindrome(word.substring(index, i + 1))) {
                    if (par[index] == null) {
                        par[index] = new ArrayList<Integer>();
                    }
                    par[index].add(i - index + 1);
                }
            }
            index--;
        }
    }

    public void printAr() {
        for (List l : par) {
            System.out.println(l);
        }
    }

    private boolean isPalindrome(String word) {
        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }


}