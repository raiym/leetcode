package com.getadhell.leetcode.P207;

/**
 * https://leetcode.com/problems/course-schedule/description/
 */
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] matrix = new boolean[numCourses * numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            matrix[prerequisites[i][1] * numCourses + prerequisites[i][0]] = true;
        }

        for (int i = 0; i < numCourses; i++) {
            for (int j = 0; j < numCourses; j++) {
                if (matrix[i * numCourses + j]) {
                    for (int p = 0; p < numCourses; p++) {
                        if (matrix[j * numCourses + p]) {
                            matrix[i * numCourses + p] = true;
                        }
                    }
                }
            }
            if (matrix[i * numCourses + i]) {
                return false;
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (matrix[i * numCourses + i]) {
                return false;
            }
        }
        return true;
    }
}