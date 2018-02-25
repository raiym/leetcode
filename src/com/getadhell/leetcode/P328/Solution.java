package com.getadhell.leetcode.P328;
/**
 * https://leetcode.com/problems/odd-even-linked-list/
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;

        ListNode temp = null;
        int index = 1;
        while (head.next != null) {
            temp = head.next;
            if (head.next.next != null) {
                head.next = head.next.next;
            } else {
                head.next = null;
                break;
            }
            head = temp;
            index++;
        }
        if (index % 2 == 1) {
            head.next = even;
        } else {
            temp.next = even;
        }

        return odd;
    }
}
