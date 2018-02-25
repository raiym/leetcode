package com.getadhell.leetcode.P143;

/**
 * https://leetcode.com/problems/reorder-list/description/
 */


public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode current = head;
        int size = 0;
        while (current != null) {
            size++;
            current = current.next;
        }
        current = head;
        int i = 0;
        while (i < size / 2 - 1) {
            current = current.next;
            i++;
        }
        ListNode secondHalf = current.next;
        current.next = null;
        current = secondHalf;

        ListNode prev = null;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        secondHalf = prev;
        //printListNode(secondHalf);

        current = head;
        ListNode temp = null;
        ListNode temp2 = null;
        while (secondHalf != null) {
            temp = current.next;
            current.next = secondHalf;
            temp2 = secondHalf.next;
            if (temp == null) {
                return;
            }
            secondHalf.next = temp;
            secondHalf = temp2;
            current = temp;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}