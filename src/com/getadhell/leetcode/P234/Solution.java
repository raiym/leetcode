package com.getadhell.leetcode.P234;

/**
 * https://leetcode.com/problems/palindrome-linked-list/description/
 */

public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode middle = head;
        int numberOfNodes = 0;
        ListNode prev = null;
        ListNode next = head;
        while (head != null) {
            numberOfNodes++;
            if (numberOfNodes % 2 != 0 && numberOfNodes > 1 ) {
                next = middle.next;
                middle.next = prev;
                prev = middle;
                middle = next;
            }
            head = head.next;
        }

        if (numberOfNodes % 2 == 0) {
            ListNode temp = next;
            next = next.next;
            temp.next = prev;
            prev = temp;
        } else {
            next = next.next;
        }

        // System.out.println(numberOfNodes);
        // System.out.println(prev.val);
        // System.out.println(next.val);
        while (prev != null) {
            if (prev.val != next.val) {
                return false;
            }
            prev = prev.next;
            next = next.next;
        }
        return true;
    }
}

 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }