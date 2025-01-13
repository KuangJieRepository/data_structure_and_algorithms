package com.kj.力扣.mid;

class Solution_198_打家劫舍 {
    public static void main(String[] args) {

    }

    /**
     * 核心在于：推导动态规划方程
     * f(n) = max(f(n-1), f(n-2)+nums[n])
     */
    static class Solution {
        public int rob(int[] nums) {
            int[] dp = new int[nums.length + 1];
            dp[0] = 0;
            dp[1] = nums[0];

            // 需要推导到最后
            for (int i = 2; i < dp.length; i++) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
            }

            return dp[dp.length - 1];
        }
    }
}