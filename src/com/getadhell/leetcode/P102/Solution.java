package com.getadhell.leetcode.P102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(root);
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> list;
        while (true) {
            list = new ArrayList<>();
            while (!queue1.isEmpty()) {
                TreeNode node = queue1.poll();
                if (node != null) {
                    list.add(node.val);
                    queue2.offer(node.left);
                    queue2.offer(node.right);
                }
            }
            if (list.size() != 0) {
                answer.add(list);
            }
            list = new ArrayList<Integer>();
            while (!queue2.isEmpty()) {
                TreeNode node = queue2.poll();
                if (node != null) {
                    list.add(node.val);
                    queue1.offer(node.left);
                    queue1.offer(node.right);
                }
            }
            if (list.size() == 0) {
                break;
            }
            answer.add(list);
        }
        return answer;
    }
}