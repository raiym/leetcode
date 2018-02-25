package com.getadhell.leetcode.P567;

class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] pattern1 = new int[26];
        int[] pattern2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            pattern1[s1.charAt(i) - 'a']++;
        }

        for (int cursor = 0; cursor < s2.length(); cursor++) {
            for (int pointer = cursor; pointer <= cursor + s1.length(); pointer++) {
                boolean answered = true;
                if (pointer - cursor == s1.length()) {
                    for (int i = 0; i < pattern1.length; i++) {
                        if (pattern1[i] != 0) {
                            answered = false;
                            break;
                        }
                    }
                    if (answered) return true;
                }
                if (pointer >= s2.length()) {
                    return false;
                }
                int index = s2.charAt(pointer) - 'a';
                if (pattern1[index] != 0) {
                    pattern1[index]--;
                    pattern2[index]++;
                } else {
                    if (pattern2[index] == 0) {
                        cursor = pointer;
                        for (int p = 0; p < pattern2.length; p++) {
                            pattern1[p] += pattern2[p];
                            pattern2[p] = 0;
                        }
                        break;
                    } else {
                        for (int p = cursor; p < pointer; p++) {
                            int curIndex = s2.charAt(p) - 'a';
                            if (curIndex == index) {
                                cursor = p + 1;
                                break;
                            }
                            pattern1[curIndex]++;
                            pattern2[curIndex]--;
                        }
                    }
                }

            }
        }
        return false;

    }
}
