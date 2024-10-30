package com.kj.力扣.easy;

import java.util.Arrays;

/**
 * 合并两个有序数组
 *
 */
class Solution_88_合并两个有序数组 {
    public static void main(String[] args) {
        // int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums1 = {7, 8, 9, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        new Solution_88_合并两个有序数组().merge(nums1, 3, nums2, 3);

        System.out.println(Arrays.toString(nums1)); // [1,2,2,3,5,6]
    }

    /**
     * 定义三个指针
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i1 = m - 1;
        int i2 = n - 1;
        int cur = nums1.length - 1;

        while (i2 >= 0) {
            // 有可能 num1的数据全部比nums2的数据大
            if (i1 >= 0 && nums2[i2] < nums1[i1]) {
                nums1[cur--] = nums1[i1--];
            } else {
                nums1[cur--] = nums2[i2--];
            }
        }
    }
}