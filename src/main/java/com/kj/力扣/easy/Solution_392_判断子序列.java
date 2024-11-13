package com.kj.力扣.easy;

class Solution_392_判断子序列 {
    public static void main(String[] args) {

    }

    static class Solution {
        public boolean isSubsequence(String s, String t) {
            int last = 0;
            int fast = 0;
            while (fast < t.length() && last < s.length()) {
                if (s.charAt(last) != t.charAt(fast)) {
                    fast++;
                } else {
                    last++;
                    fast++;
                }
            }

            return last == s.length();
        }
    }
}