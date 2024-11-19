package com.kj.力扣.easy;

import java.util.HashMap;
import java.util.Map;

class Solution_219_存在重复元素II {
    public static void main(String[] args) {

    }

    static class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                Integer index = map.get(nums[i]);
                if (index != null && Math.abs(index - i) <= k) {
                    return true;
                }
                map.put(nums[i], i);
            }

            return false;
        }
    }
}