package com.kj.排序;

import java.util.Arrays;

/**
 * 快排
 * 思想：
 * 确定基准元素 P，L R 双指针。循环条件 L 应该不等于 R
 * L指向的元素如果小于等于基准元素，向左移动
 * R指向的元素如果大于基准原色，向右移动。
 * 当 L=R 时，比较 arr[L] 和 P，如果 P > arr[L]，进行交换
 * 返回这个 L 就是分割两边的索引。
 *
 * 让左边和右边分别再次调用这个排序，当 start = end 的时候，终止
 *
 * 需要先控制右指针
 *
 * @author kj
 * @date 2024/10/15
 */
public class QuickSort_快速排序 {
    public static void main(String[] args) {
        int[] arr1 = {6, 5, 4, 3, 2, 1};
        int[] arr2 = {5, 4, 3, 2, 1};

        sort(arr1, 0, arr1.length - 1);
        sort(arr2, 0, arr2.length - 1);

        System.out.println("arr1：：" + Arrays.toString(arr1));
        System.out.println("arr2：：" + Arrays.toString(arr2));
    }

    public static void sort(int[] arr, int start, int end) {
        // 递归终止条件
        if (start >= end) {
            return;
        }

        // 寻找分割数据元素的索引
        int s = getSplitIndex(arr, start, end);

        // 递归分治思想
        sort(arr, start, s - 1);
        sort(arr, s + 1, end);
    }

    private static int getSplitIndex(int[] arr, int start, int end) {
        int p = arr[start];
        int l = start;
        int r = end;

        while (l != r) {
            // 控制右指针，先控制右指针
            while ((l < r) && (arr[r] > p)) {
                r--;
            }
            // 控制左指针
            while ((l < r) && (arr[l] <= p)) {
                l++;
            }
            // 左右指针都不满足，需要进行数据交换
            if (l < r) {
                int tmp = arr[l];
                arr[l] = arr[r];
                arr[r] = tmp;
            }
        }

        if (p > arr[l]) {
            arr[start] = arr[l];
            arr[l] = p;
        }

        // 分割点索引，左边是 小于等于的，右边是大于的
        return l;
    }
}
