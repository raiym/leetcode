package com.getadhell.leetcode.P2;

/**
 * https://leetcode.com/problems/add-two-numbers/description/
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode head = l3;
        ListNode next = null;
        ListNode last = null;

        while (true) {
            int l1Val = 0;
            int l2Val = 0;
            if (l1 != null) {
                l1Val = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                l2Val = l2.val;
                l2 = l2.next;
            }
            next = new ListNode((l3.val + l1Val + l2Val) / 10);
            l3.val = (l3.val + l1Val + l2Val) % 10;
            l3.next = next;
            last = l3;
            l3 = l3.next;
            if (l1 == null && l2 == null) {
                break;
            }
        }
        if (last.next.val == 0) {
            last.next = null;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}