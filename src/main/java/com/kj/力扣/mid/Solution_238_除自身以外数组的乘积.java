package com.kj.力扣.mid;

/**
 * 除自身以外数组的乘积 = 它的前缀积 * 它的后缀积
 */
class Solution_238_除自身以外数组的乘积 {
    public static void main(String[] args) {

    }

    static class Solution {
        public int[] productExceptSelf(int[] nums) {
            int n = nums.length;
            int[] pre = new int[n];
            int[] post = new int[n];
            int[] ans = new int[n];

            pre[0] = 1;
            for (int i = 1; i < n; i++) {
                pre[i] = pre[i - 1] * nums[i - 1];
            }

            post[n - 1] = 1;
            for (int i = n - 2; i >= 0; i--) {
                post[i] = nums[i + 1] * post[i + 1];
            }

            for (int i = 0; i < n; i++) {
                ans[i] = pre[i] * post[i];
            }

            return ans;
        }
    }
}