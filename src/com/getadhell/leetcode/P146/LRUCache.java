package com.getadhell.leetcode.P146;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/lru-cache/description/
 */
public class LRUCache {
    private Map<Integer, ListNode> map;
    private ListNode firstNode;
    private ListNode lastNode;
    private int currentSize;
    private int capacity;


    public LRUCache(int capacity) {
        this.currentSize = 0;
        this.capacity = capacity;
        this.map = new HashMap<Integer, ListNode>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        ListNode node = map.get(key);
        remove(node);
        setHead(node);
        return node.data;
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            node.data = value;
            remove(node);
            setHead(node);
            return;
        }
        if (this.currentSize == this.capacity) {
            this.currentSize--;
            map.remove(lastNode.index);
            remove(lastNode);
        }
        ListNode node = new ListNode(value, key);
        setHead(node);
        map.put(key, node);
        currentSize++;
    }

    private void remove(ListNode node) {
        ListNode prev = node.prev;
        ListNode next = node.next;
        if (prev != null) {
            prev.next = next;
        } else {
            firstNode = next;
        }
        if (next != null) {
            next.prev = prev;
        } else {
            lastNode = node.prev;
        }
    }

    private void setHead(ListNode node) {
        node.next = firstNode;
        node.prev = null;
        if (firstNode != null) {
            firstNode.prev = node;
        }
        firstNode = node;
        if (lastNode == null) {
            lastNode = firstNode;
        }
    }

    private static class ListNode {
        ListNode prev;
        ListNode next;
        int data;
        int index;

        public ListNode(int data, int index) {
            this.data = data;
            this.index = index;
        }
    }
}
