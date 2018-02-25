package com.getadhell.leetcode.P101;

/**
 * https://leetcode.com/problems/symmetric-tree/description/
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
    boolean answer;

    public boolean isSymmetric(TreeNode root) {

        if (root == null) return true;
        answer = true;
        calc(root.left, root.right);
        return answer;

    }

    private void calc(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return;
        }
        if (node1 == null && node2 != null) {
            answer = false;
            return;
        }
        if (node1 != null && node2 == null) {
            answer = false;
            return;
        }
        if (node1.val != node2.val) {
            answer = false;
            return;
        }
        calc(node1.left, node2.right);
        calc(node1.right, node2.left);
    }
}
