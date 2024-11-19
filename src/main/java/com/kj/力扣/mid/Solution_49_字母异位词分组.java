package com.kj.力扣.mid;

import java.util.*;

class Solution_49_字母异位词分组 {
    public static void main(String[] args) {

    }

    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {

            Map<String, List<String>> map = new HashMap<>();

            for (String str : strs) {
                char[] c = str.toCharArray();
                Arrays.sort(c);
                String k = Arrays.toString(c);

                List<String> v = map.getOrDefault(k, new ArrayList<>());
                v.add(str);
                map.put(k, v);
            }

            return new ArrayList<>(map.values());
        }
    }
}