package com.kj.力扣.easy;

class Solution_14_最长公共前缀 {
    public static void main(String[] args) {
        String[] strs = new String[]{"flower", "flow", "flight"};

        System.out.println(new Solution().longestCommonPrefix(strs));
    }

    static class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null) return "";

            String ans = strs[0];

            for (String str : strs) {
                while (!str.startsWith(ans)) {
                    if (ans.length() == 0) return "";
                    ans = ans.substring(0, ans.length() - 1);
                }
            }

            return ans;
        }
    }
}