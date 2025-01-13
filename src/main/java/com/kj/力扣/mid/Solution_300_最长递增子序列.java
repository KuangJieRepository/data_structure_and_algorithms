package com.kj.力扣.mid;

import java.util.ArrayList;
import java.util.List;

class Solution_300_最长递增子序列 {
    public static void main(String[] args) {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(new Solution().lengthOfLIS(nums));
    }

    static class Solution {
        public int lengthOfLIS(int[] nums) {
            List<Integer> res = new ArrayList<>();

            for (int target : nums) {
                int search = binarySearch(res, target);
                if (search == -1) {
                    res.add(target);
                } else {
                    res.set(search, target);
                }
            }

            return res.size();
        }

        // 寻找第一个大于等于的元素
        private int binarySearch(List<Integer> res, int target) {
            int i = 0, j = res.size() - 1;
            int tmp = -1;
            while (i <= j) {
                int m = (i + j) >> 1;
                if (res.get(m) < target) {
                    i = m + 1;
                } else {
                    tmp = m;
                    j = m - 1;
                }
            }

            return tmp;
        }
    }
}