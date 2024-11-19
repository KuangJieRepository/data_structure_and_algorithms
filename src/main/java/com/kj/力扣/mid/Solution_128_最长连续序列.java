package com.kj.力扣.mid;

import java.util.HashSet;
import java.util.Set;

class Solution_128_最长连续序列 {
    public static void main(String[] args) {

    }

    static class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }

            int maxLen = 0;

            for (int num : nums) {
                if (!set.contains(num - 1)) {
                    // 左边不存在，说明是起点
                    // 存储当前连续序列的长度
                    int len = 0;
                    while (set.contains(num + len)) {
                        len++;
                        maxLen = Math.max(maxLen, len);
                    }
                }
            }

            return maxLen;
        }
    }
}