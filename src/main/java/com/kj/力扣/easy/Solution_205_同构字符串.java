package com.kj.力扣.easy;

import java.util.HashMap;
import java.util.Map;

class Solution_205_同构字符串 {
    public static void main(String[] args) {

    }

    static class Solution {
        public boolean isIsomorphic(String s, String t) {
            Map<Character, Character> s2t = new HashMap<>(), t2s = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {
                Character a = s.charAt(i), b = t.charAt(i);
                if (s2t.containsKey(a) && !s2t.get(a).equals(b)) return false;
                if (t2s.containsKey(b) && !t2s.get(b).equals(a)) return false;

                s2t.put(a, b);
                t2s.put(b, a);
            }

            return true;
        }
    }
}