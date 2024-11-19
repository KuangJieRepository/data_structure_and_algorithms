package com.kj.力扣.easy;

import java.util.HashMap;
import java.util.Map;

class Solution_383_赎金信 {
    public static void main(String[] args) {

    }

    static class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            Map<Character, Integer> map = new HashMap<>();

            for (int i = 0; i < magazine.length(); i++) {
                char key = magazine.charAt(i);
                map.put(key, map.getOrDefault(key, 0) + 1);
            }

            int count = 0;

            for (int i = 0; i < ransomNote.length(); i++) {
                char key = ransomNote.charAt(i);

                Integer n = map.get(key);

                if (n != null && n > 0) {
                    count++;
                    map.put(key, map.get(key) - 1);
                }
            }

            return count == ransomNote.length();
        }
    }
}