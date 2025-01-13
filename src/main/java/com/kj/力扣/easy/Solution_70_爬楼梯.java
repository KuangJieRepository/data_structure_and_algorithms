package com.kj.力扣.easy;

class Solution_70_爬楼梯 {
    public static void main(String[] args) {

    }

    /**
     * 核心：画决策树，推导动态规划方程
     * f(n) = f(n-1) + f(n-2)
     */
    static class Solution {
        public int climbStairs(int n) {
            int pre1 = 1; // n - 2
            int pre2 = 1; // n - 1
            int cur = 1;  // n

            for (int i = 2; i <= n; i++) {
                cur = pre1 + pre2;
                pre1 = pre2;
                pre2 = cur;
            }

            return cur;
        }
    }
}