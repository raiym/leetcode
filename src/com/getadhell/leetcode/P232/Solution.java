package com.getadhell.leetcode.P232;

/**
 * https://leetcode.com/problems/implement-queue-using-stacks/description/
 */
class MyQueue {
    private MyStack pushStack;
    private MyStack popStack;


    public MyQueue() {
        pushStack = new MyStack();
        popStack = new MyStack();
    }


    // Push element x to the back of queue.
    public void push(int x) {
        if (!pushStack.empty()) {
            pushStack.push(x);
            return;
        }
        while (!popStack.empty()) {
            int data = popStack.pop();
            pushStack.push(data);
        }
        pushStack.push(x);
    }

    // Removes the element from in front of queue.
    public int pop() {
        if (!popStack.empty()) {
            return popStack.pop();
        }
        while (!pushStack.empty()) {
            int data = pushStack.pop();
            popStack.push(data);
        }
        return popStack.pop();
    }

    // Get the front element.
    public int peek() {
        if (!popStack.empty()) {
            return popStack.peek();
        }
        while (!pushStack.empty()) {
            int data = pushStack.pop();
            popStack.push(data);
        }
        return popStack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return pushStack.empty() && popStack.empty();
    }


    private static class MyStack {
        private StackNode top;
        private int size;

        public MyStack() {
            this.size = 0;
        }

        public int pop() {
            StackNode item = top;
            top = top.next;
            size--;
            return item.data;
        }

        public int peek() {
            return top.data;
        }

        public void push(int data) {
            StackNode item = new StackNode(data);
            item.next = top;
            top = item;
            size++;
        }

        public boolean empty() {
            return size == 0;
        }

        private static class StackNode {
            public int data;
            public StackNode next;

            public StackNode(int data) {
                this.data = data;
            }
        }
    }
}