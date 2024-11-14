package com.kj.力扣.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution_15_三数之和 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};

        System.out.println(new Solution().threeSum(nums));
    }

    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            // 排序
            Arrays.sort(nums);

            List<List<Integer>> ans = new ArrayList<>();

            for (int i = 0; i < nums.length - 2; i++) {
                // 去重
                if (i > 0 && nums[i] == nums[i - 1]) continue;

                // 问题简化成两数只和
                int sum = 0 - nums[i];
                int j = i + 1;
                int k = nums.length - 1;

                while (j < k) {
                    if (nums[j] + nums[k] < sum) {
                        j++;
                    } else if (nums[j] + nums[k] > sum) {
                        k--;
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        ans.add(list);

                        // 继续判断后续是否还有符合的组合
                        j++;
                        k--;

                        // 再次去重，相等的话，就不用再次参与计算了
                        // 使用 while ，将所有相等的都排除
                        while (j < k && nums[j] == nums[j - 1]) j++;
                        while (j < k && nums[k] == nums[k + 1]) k--;
                    }
                }
            }

            return ans;
        }
    }
}