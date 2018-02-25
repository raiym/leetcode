package com.getadhell.leetcode.P20;

/**
 * https://leetcode.com/problems/valid-parentheses/description/
 */
public class Solution {
    public boolean isValid(String s) {

        MyStack stack = new MyStack();
        for (int index = 0; index < s.length(); index++) {
            char c = s.charAt(index);
            switch (c) {
                case '[':
                    stack.push(c);
                    break;
                case '{':
                    stack.push(c);
                    break;
                case '(':
                    stack.push(c);
                    break;
                case '}':
                    if (stack.pop() != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.pop() != '[') {
                        return false;
                    }
                    break;
                case ')':
                    if (stack.pop() != '(') {
                        return false;
                    }
                    break;
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }


    }

    public static class MyStack {
        StackNode top;

        public void push(char data) {
            StackNode item = new StackNode(data);
            item.next = top;
            top = item;

        }

        public boolean isEmpty() {
            return top == null;
        }

        public char pop() {
            if (top == null) {
                return 'N';
            }
            StackNode item = top;
            top = top.next;
            return item.data;
        }

        private class StackNode {
            char data;
            StackNode next;

            public StackNode(char data) {
                this.data = data;
            }
        }
    }

}