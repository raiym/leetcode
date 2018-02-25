package com.getadhell.leetcode.P155;

/**
 * https://leetcode.com/problems/min-stack/description/
 */
public class MinStack {
    private StackNode top;

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        StackNode item = new StackNode(x);
        item.next = top;
        if (top != null) {
            item.subMin = top.subMin;
            if (top.subMin > item.data) {
                item.subMin = item.data;
            }
        } else {
            item.subMin = item.data;
        }

        top = item;
    }

    public int pop() {
        if (top == null) {
            return 0;
        }
        StackNode item = top;
        top = top.next;
        return item.data;
    }

    public int top() {
        if (top == null) {
            return 0;
        }
        return top.data;
    }

    public int getMin() {
        if (top == null) {
            return 0;
        }
        return top.subMin;
    }

    private static class StackNode {
        private int data;
        private StackNode next;
        private int subMin;

        public StackNode(int data) {
            this.data = data;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */