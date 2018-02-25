package com.getadhell.leetcode.P226;

/**
 * https://leetcode.com/problems/invert-binary-tree/description/
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        traversal(root);
        return root;
    }

    private void traversal(TreeNode node) {
        if (node == null) {
            return;
        }
        traversal(node.left);
        traversal(node.right);
        visit(node);
    }

    private void visit(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
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
