package com.kj.力扣.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Solution_290_单词规律 {
    public static void main(String[] args) {

    }

    /**
     * 利用  map put 时的返回值
     */
    static class Solution {
        public boolean wordPattern(String pattern, String s) {
            String[] words = s.split(" ");

            if (pattern.length() != words.length) return false;

            Map<String, Integer> map1 = new HashMap<>();
            Map<String, Integer> map2 = new HashMap<>();

            for (int i = 0; i < pattern.length(); i++) {
                if (!Objects.equals(map1.put(String.valueOf(pattern.charAt(i)), i), map2.put(words[i], i))) {
                    return false;
                }
            }

            return true;
        }
    }
}