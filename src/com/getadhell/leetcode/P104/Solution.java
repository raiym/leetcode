package com.getadhell.leetcode.P104;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 */


public class Solution {
    int max = 0;

    public int maxDepth(TreeNode root) {
        traverse(root, 0);
        return max;
    }

    public void traverse(TreeNode node, int step) {
        if (node == null) {
            return;
        }
        step++;
        if (node.left != null) {
            traverse(node.left, step);
        }
        visit(step);
        if (node.right != null) {
            traverse(node.right, step);
        }
    }

    public void visit(int depth) {
        if (depth > max) {
            max = depth;
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