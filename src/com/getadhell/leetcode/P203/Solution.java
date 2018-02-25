package com.getadhell.leetcode.P203;

/**
 * https://leetcode.com/problems/remove-linked-list-elements/description/
 */

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode trueHead = head;
        ListNode prev = null;
        while (head != null) {
            if (head.val == val && prev != null) {
                prev.next = head.next;
                head = head.next;
                continue;
            }
            prev = head;
            head = head.next;
        }
        if (trueHead.val == val) {
            return trueHead.next;
        }
        return trueHead;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
