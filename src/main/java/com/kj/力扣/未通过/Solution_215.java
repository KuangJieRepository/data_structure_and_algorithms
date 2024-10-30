package com.kj.力扣.未通过;

/**
 * 未通过
 *
 * @author kj
 * @date 2024/10/16
 */
public class Solution_215 {
    public static void main(String[] args) {
        int[] arr1 = {6, 5, 4, 3, 2, 1};
        int rs = new Solution_215().findKthLargest(arr1, 1);
        System.out.println(rs);
    }

    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    public void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = getSplitIndex(nums, start, end);

        quickSort(nums, start, mid - 1);
        quickSort(nums, mid + 1, end);
    }

    public int getSplitIndex(int[] nums, int start, int end) {
        int p = nums[start];
        int l = start;
        int r = end;

        while (l != r) {
            while ((l < r) && (nums[r] > p)) {
                r--;
            }
            while ((l < r) && (nums[l] <= p)) {
                l++;
            }

            if (l < r) {
                int tmp = nums[r];
                nums[r] = nums[l];
                nums[l] = tmp;
            }
        }

        if (p > nums[l]) {
            nums[start] = nums[l];
            nums[l] = p;
        }

        return l;
    }
}
