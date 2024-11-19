package com.kj.力扣.easy;

import java.util.ArrayList;
import java.util.List;

class Solution_228_汇总区间 {
    public static void main(String[] args) {

    }

    static class Solution {
        public List<String> summaryRanges(int[] nums) {
            List<String> ans = new ArrayList<>();

            int len = nums.length;

            int left = 0;

            for (int right = 0; right < len; right++) {
                StringBuilder sb = new StringBuilder();
                if (right + 1 == len || nums[right] + 1 != nums[right + 1]) {
                    sb.append(nums[left]);
                    if (right != left) {
                        sb.append("->").append(nums[right]);
                    }
                    ans.add(sb.toString());
                    left = right + 1;
                }
            }

            return ans;
        }
    }
}