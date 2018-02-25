package com.getadhell.leetcode.P92;

/**
 * https://leetcode.com/problems/reverse-linked-list-ii/description/
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode current = head;

        ListNode beforeNode = null;
        ListNode mNode = null;
        int index = 1;
        while (current != null) {
            if (index == m - 1) {
                beforeNode = current;
            }

            if (index == m) {
                mNode = current;
                ListNode prev = null;
                while (index != n + 1) {
                    ListNode next = current.next;
                    current.next = prev;
                    prev = current;
                    current = next;
                    index++;
                }
                mNode.next = current;
                if (beforeNode != null) {
                    beforeNode.next = prev;
                }
                if (beforeNode == null) {
                    return prev;
                }
                return head;
            }
            index++;
            current = current.next;
        }
        return head;
    }
}
