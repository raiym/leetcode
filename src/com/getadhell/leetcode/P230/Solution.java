package com.getadhell.leetcode.P230;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
 */
public class Solution {
    int s = 0;
    int search = 0;
    boolean isAnswered = false;

    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return search;
    }

    private void traverse(TreeNode node, int k) {
        if (node == null) {
            return;
        }
        if (isAnswered) {
            return;
        }
        traverse(node.left, k);
        visit(node, k);
        traverse(node.right, k);
    }

    private void visit(TreeNode node, int k) {
        s++;
        if (s == k) {
            search = node.val;
            isAnswered = true;
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}