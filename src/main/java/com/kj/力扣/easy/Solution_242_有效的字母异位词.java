package com.kj.力扣.easy;

import java.util.Arrays;

class Solution_242_有效的字母异位词 {
    public static void main(String[] args) {

    }

    static class Solution {
        public boolean isAnagram(String s, String t) {
            char[] arrS = s.toCharArray();
            char[] arrT = t.toCharArray();
            Arrays.sort(arrS);
            Arrays.sort(arrT);
            return Arrays.equals(arrS, arrT);
        }
    }
}