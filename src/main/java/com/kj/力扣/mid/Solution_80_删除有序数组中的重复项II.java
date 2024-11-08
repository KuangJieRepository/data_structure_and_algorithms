package com.kj.力扣.mid;

class Solution_80_删除有序数组中的重复项II {
    public static void main(String[] args) {

    }

    static class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums.length == 1) return 1;

            int frequency = 1;

            int slow = 1;

            for (int fast = 1; fast < nums.length; fast++) {
                if (nums[fast] == nums[slow - 1] && frequency < 2) {
                    frequency++;
                    nums[slow] = nums[fast];
                    slow++;
                }

                if (nums[fast] != nums[slow - 1]) {
                    frequency = 1;
                    nums[slow] = nums[fast];
                    slow++;
                }
            }

            return slow;
        }
    }
}