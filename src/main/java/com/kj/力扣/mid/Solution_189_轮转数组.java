package com.kj.力扣.mid;

import java.util.Arrays;

class Solution_189_轮转数组 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};

        new Solution().rotate(nums, 3);

        System.out.println(Arrays.toString(nums));
    }

    static class Solution {
        public void rotate(int[] nums, int k) {
            k %= nums.length;

            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);
        }

        private void reverse(int[] nums, int l, int r) {
            while (l < r) {
                int tmp = nums[l];
                nums[l++] = nums[r];
                nums[r--] = tmp;
            }
        }
    }
}