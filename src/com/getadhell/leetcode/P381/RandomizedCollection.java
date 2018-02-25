package com.getadhell.leetcode.P381;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/description/
 */
public class RandomizedCollection {
    List<Integer> list;
    java.util.Random rand;
    Map<Integer, Integer> map;

    /**
     * Initialize your data structure here.
     */
    public RandomizedCollection() {
        this.list = new ArrayList<>();
        this.rand = new java.util.Random();
        this.map = new HashMap<Integer, Integer>();
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        this.list.add(val);
        if (this.map.get(val) == null) {
            this.map.put(val, 1);
            return true;
        }
        this.map.put(val, this.map.get(val) + 1);
        return false;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        if (this.map.get(val) == null || this.map.get(val) == 0) {
            return false;
        }
        this.map.put(val, this.map.get(val) - 1);
        this.list.remove(new Integer(val));
        return true;

    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        int randomNum = this.rand.nextInt(list.size());
        return list.get(randomNum);

    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */