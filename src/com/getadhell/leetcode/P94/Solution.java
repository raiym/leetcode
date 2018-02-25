package com.getadhell.leetcode.P94;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    private List<Integer> tree;

    public List<Integer> inorderTraversal(TreeNode root) {
        tree = new ArrayList<Integer>();
        go(root);
        return tree;
    }

    private void go(TreeNode node) {
        if (node == null) {
            return;
        }
        go(node.left);
        visit(node);
        go(node.right);

    }

    public void visit(TreeNode node) {
        if (node == null) {
            tree.add(null);
        } else {
            tree.add(node.val);
        }
    }
}
