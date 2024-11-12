package com.kj.力扣.mid;

/**
 * 贪心的思想：假设每次都去跳最大步数
 */
class Solution_55_跳跃游戏 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 1, 4};

        System.out.println(new Solution().canJump(nums));

        int[] nums2 = new int[]{3, 2, 1, 0, 4};

        System.out.println(new Solution().canJump(nums2));
    }

    static class Solution {
        public boolean canJump(int[] nums) {
            if (nums == null) return false;

            int ans = nums.length - 1;
            for (int i = nums.length - 2; i >= 0; i--) {
                if ((nums[i] + i) >= ans) {
                    ans = i;
                }
            }

            return ans == 0;
        }
    }
}