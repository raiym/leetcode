package com.getadhell.leetcode.P341;

/**
 * https://leetcode.com/problems/flatten-nested-list-iterator/description/
 */

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 * <p>
 * // @return true if this NestedInteger holds a single integer, rather than a nested list.
 * public boolean isInteger();
 * <p>
 * // @return the single integer that this NestedInteger holds, if it holds a single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 * <p>
 * // @return the nested list that this NestedInteger holds, if it holds a nested list
 * // Return null if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */

interface NestedInteger {
    public boolean isInteger();

    public Integer getInteger();

    public List<NestedInteger> getList();
}

public class NestedIterator implements Iterator<Integer> {
    private int indexInList;
    private List<NestedInteger> nestedList;
    private Queue<Integer> queue;
    private boolean isIntegerExist;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.indexInList = 0;
        this.nestedList = nestedList;
        this.queue = new LinkedList<Integer>();
    }

    @Override
    public Integer next() {
        if (this.queue.isEmpty() && this.hasNext()) {
            NestedInteger nestedInteger = this.nestedList.get(indexInList);
            this.fillQueue(nestedInteger);
            indexInList++;
        }
        Integer value = this.queue.poll();
        return value;
    }

    @Override
    public boolean hasNext() {
        if (!this.queue.isEmpty()) {
            return true;
        }
        while (this.indexInList < this.nestedList.size()) {
            this.isIntegerExist = false;
            NestedInteger nestedInteger = this.nestedList.get(this.indexInList);
            skipNulls(nestedInteger);
            if (this.isIntegerExist) {
                break;
            }
            this.indexInList++;
        }
        if (this.indexInList >= nestedList.size()) {
            return false;
        }
        return true;
    }

    private void fillQueue(NestedInteger nestedInteger) {
        if (nestedInteger.isInteger()) {
            this.queue.offer(nestedInteger.getInteger());
            return;
        }
        for (NestedInteger ni : nestedInteger.getList()) {
            fillQueue(ni);
        }
    }

    private void skipNulls(NestedInteger nestedInteger) {
        if (nestedInteger.isInteger()) {
            this.isIntegerExist = true;
            return;
        }
        for (NestedInteger ni : nestedInteger.getList()) {
            skipNulls(ni);
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
