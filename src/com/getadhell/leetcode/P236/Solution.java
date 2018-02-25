package com.getadhell.leetcode.P236;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        LinkedList<TreeNode> path1 = new LinkedList<>();
        if (traverse(path1, root, p)) {
            path1.addFirst(root);
        }
        LinkedList<TreeNode> path2 = new LinkedList<>();
        if (traverse(path2, root, q)) {
            path2.addFirst(root);
        }

        int i = 0;
        while (true) {
            if (i > 0 && i == path1.size()) {
                return path1.get(i - 1);
            }
            if (i > 0 && i == path2.size()) {
                return path2.get(i - 1);
            }
            if (path1.get(i) == path2.get(i)) {
                i++;
                continue;
            }
            return path1.get(i - 1);
        }
    }

    public boolean traverse(LinkedList<TreeNode> path, TreeNode currentNode, TreeNode searchNode) {
        if (currentNode == null) {
            return false;
        }
        if (currentNode == searchNode) {
            return true;
        }
        if (traverse(path, currentNode.left, searchNode)) {
            path.addFirst(currentNode.left);
            return true;
        }
        if (traverse(path, currentNode.right, searchNode)) {
            path.addFirst(currentNode.right);
            return true;
        }
        return false;
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