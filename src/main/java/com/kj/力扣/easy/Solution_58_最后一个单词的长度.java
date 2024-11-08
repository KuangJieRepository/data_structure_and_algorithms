package com.kj.力扣.easy;

class Solution_58_最后一个单词的长度 {
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLastWord("Hello World"));
    }

    static class Solution {
        public int lengthOfLastWord(String s) {
            if (s == null) return 0;

            char[] chars = s.toCharArray();

            int ans = 0;
            for (int i = chars.length - 1; i >= 0; i--) {
                if (chars[i] != ' ') {
                    ans++;
                } else if (ans != 0) {
                    return ans;
                }
            }

            return ans;
        }
    }
}