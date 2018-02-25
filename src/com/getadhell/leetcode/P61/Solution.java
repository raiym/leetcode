package com.getadhell.leetcode.P61;

/**
 * https://leetcode.com/problems/rotate-list/description/
 */

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        if (k == 0) {
            return head;
        }

        ListNode current = head;
        int listSize = 0;
        while (current != null) {
            current = current.next;
            listSize++;
        }
        k = k % listSize;

        if (k == 0) {
            return head;
        }
        k = listSize - k;
        int index = 1;
        current = head;
        ListNode prevLast = null;
        ListNode newHead = null;
        ListNode newTail = null;
        while (current != null) {
            if (index == k) {
                newTail = current;
                newHead = current.next;
            }
            if (current.next == null) {
                prevLast = current;
            }
            index++;
            current = current.next;
        }
        newTail.next = null;
        prevLast.next = head;
        return newHead;

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}