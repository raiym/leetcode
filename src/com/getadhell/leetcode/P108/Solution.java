package com.getadhell.leetcode.P108;

/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int middleIndex = nums.length / 2;
        TreeNode root = new TreeNode(nums[nums.length / 2]);
        makeTree(nums, 0, middleIndex - 1, root, true);
        makeTree(nums, middleIndex + 1, nums.length - 1, root, false);
        return root;

    }

    private void makeTree(int[] nums, int lIndex, int rIndex, TreeNode parentNode, boolean isLeft) {
        if (lIndex > rIndex) {
            return;
        }
        int parentIndex = (lIndex + rIndex) / 2;
        TreeNode node = new TreeNode(nums[parentIndex]);
        if (isLeft) {
            parentNode.left = node;
        } else {
            parentNode.right = node;
        }
        makeTree(nums, lIndex, parentIndex - 1, node, true);
        makeTree(nums, parentIndex + 1, rIndex, node, false);
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