package com.kj.力扣.easy;

class Solution_26_删除有序数组中的重复项 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{1, 1, 2};

        System.out.println(solution.removeDuplicates(nums));
    }

    static class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums == null) return 0;
            if (nums.length <= 1) return 1;

            // 慢指针，指向的是，将要存储有效数据的位置（还没有保存有效数据），进行原地覆盖
            int cur = 1;

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != nums[cur - 1]) {
                    nums[cur++] = nums[i];
                }
            }

            return cur;
        }
    }
}