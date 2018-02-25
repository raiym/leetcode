package com.getadhell.leetcode.P150;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
 */
class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> queue = new LinkedList<>();
        int current = 0;
        int a = 0;
        int b = 0;
        for (String token : tokens) {
            switch (token) {
                case "+":
                    b = queue.removeLast();
                    a = queue.removeLast();
                    queue.add(a + b);
                    break;
                case "-":
                    b = queue.removeLast();
                    a = queue.removeLast();
                    queue.add(a - b);
                    break;
                case "*":
                    b = queue.removeLast();
                    a = queue.removeLast();
                    queue.add(a * b);
                    break;
                case "/":
                    b = queue.removeLast();
                    a = queue.removeLast();
                    queue.add(a / b);
                    break;
                default:
                    queue.add(Integer.parseInt(token));
            }
        }
        return queue.removeLast();
    }
}