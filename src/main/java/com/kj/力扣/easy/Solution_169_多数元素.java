package com.kj.力扣.easy;

/**
 * 摩尔投票
 */
class Solution_169_多数元素 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};

        System.out.println(new Solution().majorityElement(nums));
    }

    static class Solution {
        public int majorityElement(int[] nums) {
            int ans = nums[0];
            int count = 1;

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == ans) {
                    count++;
                } else if (--count == 0) {
                    ans = nums[++i];
                    count = 1;
                }
            }

            return ans;
        }
    }
}