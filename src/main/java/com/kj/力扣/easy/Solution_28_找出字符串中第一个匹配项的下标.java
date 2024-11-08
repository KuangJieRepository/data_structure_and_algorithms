package com.kj.力扣.easy;

class Solution_28_找出字符串中第一个匹配项的下标 {
    public static void main(String[] args) {
        System.out.println(new Solution().strStr("sadbutsad", "sad"));
        System.out.println(new Solution().strStr("adbutsad", "sad"));
        System.out.println(new Solution().strStr("leetcode", "leeto"));
    }

    static class Solution {
        public int strStr(String haystack, String needle) {
            int windowLen = needle.length();
            for (int i = 0; i <= haystack.length() - windowLen; i++) {
                if (haystack.substring(i, i + windowLen).equals(needle)) {
                    return i;
                }
            }

            return -1;
        }
    }
}