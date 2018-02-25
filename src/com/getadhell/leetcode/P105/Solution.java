package com.getadhell.leetcode.P105;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 */
public class Solution {

    private int preIndex;
    private int inIndex;

    private int[] preorder;
    private int[] inorder;

    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        this.preIndex = 0;
        this.inIndex = 0;
        TreeNode node = build(0, inorder.length - 1);
        return node;
    }


    public TreeNode build(int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }

        TreeNode tNode = new TreeNode(this.preorder[this.preIndex]);
        this.preIndex++;
        if (inStart == inEnd) {
            return tNode;
        }
        int index = searchForIndex(tNode.val, inStart, inEnd);
        tNode.left = build(inStart, index - 1);
        tNode.right = build(index + 1, inEnd);
        return tNode;
    }

    public int searchForIndex(int target, int inStart, int inEnd) {
        for (int i = inStart; i <= inEnd; i++) {
            if (target == this.inorder[i]) {
                return i;
            }
        }
        return -1;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
