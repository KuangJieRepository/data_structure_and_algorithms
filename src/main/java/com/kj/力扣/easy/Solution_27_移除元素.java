package com.kj.力扣.easy;

/**
 *
 *
 * @author kj
 * @date 2024/11/6
 */
public class Solution_27_移除元素 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{2, 2, 2, 2};

        int element = solution.removeElement(nums, 2);

        System.out.println(element);
    }

    static class Solution {
        public int removeElement(int[] nums, int val) {
            int cur = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != val) {
                    nums[cur++] = nums[i];
                }
            }
            return cur;
        }
    }
}
