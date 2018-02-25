package com.getadhell.leetcode.P206;

/**
 * https://leetcode.com/problems/reverse-linked-list/description/
 */


public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode tempNode = head.next;
            head.next = prev;
            prev = head;
            head = tempNode;
        }
        return prev;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}