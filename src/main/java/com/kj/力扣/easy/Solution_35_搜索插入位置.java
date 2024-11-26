package com.kj.力扣.easy;

class Solution_35_搜索插入位置 {
    public static void main(String[] args) {

    }

    /**
     *  1,3,5
     *   2
     */
    static class Solution {
        public int searchInsert(int[] nums, int target) {
            int l = 0;
            int r = nums.length - 1;

            while (l <= r) {
                int mid = (l + r) >>> 1;
                if (nums[mid] < target) {
                    l = mid + 1;
                } else if (nums[mid] > target) {
                    r = mid - 1;
                } else {
                    return mid;
                }
            }

            return l;
        }
    }
}