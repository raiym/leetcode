package com.getadhell.leetcode.P380;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/insert-delete-getrandom-o1/description/
 */
public class RandomizedSet {
    private static int M = 117;
    private List<Integer> list;
    private LinkedList<Integer>[] hashTable;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        this.hashTable = new LinkedList[M];
        this.list = new ArrayList<Integer>();
    }

    private static int hashValue(int value) {
        return Math.abs(value) % M;
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        int hash = hashValue(val);
        if (this.hashTable[hash] == null) {
            this.hashTable[hash] = new LinkedList<Integer>();
        }
        for (Integer i : this.hashTable[hash]) {
            if (i == val) {
                return false;
            }
        }
        this.list.add(hash);
        this.hashTable[hash].add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        int hash = hashValue(val);
        if (this.hashTable[hash] == null) {
            return false;
        }
        return this.hashTable[hash].removeFirstOccurrence(val);
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int index;
        int linkedIndex;
        while (true) {
            index = (int) (Math.random() * this.list.size());
            index = this.list.get(index);
            if (this.hashTable[index] == null || this.hashTable[index].size() == 0) {
                continue;
            }
            linkedIndex = (int) (this.hashTable[index].size() * Math.random());
            break;
        }
        return this.hashTable[index].get(linkedIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */