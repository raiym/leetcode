package com.getadhell.leetcode.P21;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode root;
        if (l1.val < l2.val) {
            root = l1;
            l1 = l1.next;
        } else {
            root = l2;
            l2 = l2.next;
        }
        ListNode currentNode = root;
        while (true) {
            if (l1 == null && l2 == null) {
                break;
            }
            if (l1 == null) {
                currentNode.next = l2;
                break;
            }
            if (l2 == null) {
                currentNode.next = l1;
                break;
            }
            if (l1.val < l2.val) {
                currentNode.next = l1;
                l1 = l1.next;
                currentNode = currentNode.next;
            } else {
                currentNode.next = l2;
                l2 = l2.next;
                currentNode = currentNode.next;
            }
        }
        return root;
    }
}