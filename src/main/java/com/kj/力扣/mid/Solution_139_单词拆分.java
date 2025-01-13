package com.kj.力扣.mid;

import java.util.ArrayList;
import java.util.List;

class Solution_139_单词拆分 {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(new Solution().wordBreak(s, wordDict));
    }

    static class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            for (String dict : wordDict) {
                s = s.replace(dict, "");
            }

            return s.isEmpty();
        }
    }
}