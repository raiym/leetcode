package com.getadhell.leetcode.P237;

/**
 * https://leetcode.com/problems/delete-node-in-a-linked-list/description/
 */

public class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
