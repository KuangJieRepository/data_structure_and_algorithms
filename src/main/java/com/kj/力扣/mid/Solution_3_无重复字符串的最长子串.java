package com.kj.力扣.mid;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 * @author kj
 * @date 2024/11/5
 */
public class Solution_3_无重复字符串的最长子串 {
    public static void main(String[] args) {
        String s = "abcabcbb";

        Solution solution = new Solution();

        int length = solution.lengthOfLongestSubstring(s);

        System.out.println(length);
    }

    /**
     * 滑动窗口解决
     */
    static class Solution {

        public int lengthOfLongestSubstring(String s) {
            if (s == null) return 0;

            char[] chars = s.toCharArray();
            if (chars.length == 0) return 0;

            int maxLen = 0;
            Map<Character, Integer> map = new HashMap<>();

            for (int left = 0, right = 0; right < chars.length; right++) {
                // 判断这个字符上次出现在，左边界外还是内
                left = Math.max(left, map.getOrDefault(chars[right], -1) + 1);
                maxLen = Math.max(maxLen, right - left + 1);

                map.put(chars[right], right);
            }

            return maxLen;
        }
    }
}
