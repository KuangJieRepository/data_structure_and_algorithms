package com.kj.力扣.mid;

class Solution_209_长度最小的子数组 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;

        System.out.println(new Solution().minSubArrayLen(target, nums));

        int[] nums2 = {1, 1, 1, 1, 1, 1, 1, 1};
        int target2 = 11;

        System.out.println(new Solution().minSubArrayLen(target2, nums2));
    }

    static class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            // 默认为0
            int ans = Integer.MAX_VALUE;

            int l = 0;
            int r = 0;

            int sum = 0;

            while (r < nums.length) {
                sum += nums[r];

                while (sum >= target) {
                    ans = Math.min(ans, r - l + 1);
                    sum -= nums[l];
                    l++;
                }

                r++;
            }

            return ans == Integer.MAX_VALUE ? 0 : ans;
        }
    }
}