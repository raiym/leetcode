package com.getadhell.leetcode.P103;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        boolean switcher = true;
        Deque<TreeNode> queue1 = new LinkedList<TreeNode>();
        Deque<TreeNode> queue2 = new LinkedList<TreeNode>();
        queue1.addFirst(root);
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            List<Integer> list = new ArrayList<Integer>();
            Deque<TreeNode> currentQue = (!queue1.isEmpty()) ? queue1 : queue2;
            Deque<TreeNode> secondQue = (queue1.isEmpty()) ? queue1 : queue2;
            while (!currentQue.isEmpty()) {
                TreeNode node = currentQue.pollFirst();
                // System.out.println(currentSize + " " + ((node == null) ? "null" : node.val));
                if (node != null) {
                    list.add(node.val);
                } else {
                    continue;
                }

                if (switcher) {
                    secondQue.addFirst(node.left);
                    secondQue.addFirst(node.right);
                } else {
                    secondQue.addFirst(node.right);
                    secondQue.addFirst(node.left);

                }
            }
            switcher = !switcher;
            if (list.size() != 0) {
                answer.add(list);
            }
        }
        return answer;
    }
}
