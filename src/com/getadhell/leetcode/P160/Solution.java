package com.getadhell.leetcode.P160;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/description/
 */

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aNumber = 0;
        ListNode temp = headA;
        while (temp != null) {
            aNumber++;
            temp = temp.next;
        }
        int bNumber = 0;
        temp = headB;
        while (temp != null) {
            bNumber++;
            temp = temp.next;
        }
        if (aNumber == 0 || bNumber == 0) {
            return null;
        }
        while (aNumber != bNumber) {
            if (aNumber > bNumber) {
                aNumber--;
                headA = headA.next;
            } else {
                bNumber--;
                headB = headB.next;
            }
        }
        while (headA != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}