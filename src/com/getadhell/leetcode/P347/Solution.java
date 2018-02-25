package com.getadhell.leetcode.P347;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 */
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i], 0) + 1);
        }
        for (int key : frequencyMap.keySet()) {
            int frequencyValue = frequencyMap.get(key);
            if (bucket[frequencyValue] == null) {
                bucket[frequencyValue] = new ArrayList<Integer>();
            }
            bucket[frequencyValue].add(key);
        }
        List<Integer> result = new ArrayList<Integer>();
        for (int pos = bucket.length - 1; pos >= 0; pos--) {
            if (result.size() < k && bucket[pos] != null) {
                result.addAll(bucket[pos]);
            }
        }
        return result.subList(0, k);
    }

}
