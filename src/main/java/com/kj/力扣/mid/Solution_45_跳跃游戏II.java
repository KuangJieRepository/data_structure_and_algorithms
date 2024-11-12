package com.kj.力扣.mid;

/**
 * 贪心
 * 二步贪心
 */
class Solution_45_跳跃游戏II {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 1, 4};

        System.out.println(new Solution().jump(nums));
    }

    static class Solution {
        public int jump(int[] nums) {
            if (nums == null || nums.length <= 1) return 0;

            int maxi = 0, newMax = 0, step = 0;

            for (int i = 0; i < nums.length; i++) {
                newMax = Math.max(newMax, nums[i] + i);
                if (i == maxi) {
                    maxi = newMax;
                    step++;
                    if (maxi >= nums.length - 1) {
                        break;
                    }
                }
            }

            return step;
        }
    }
}