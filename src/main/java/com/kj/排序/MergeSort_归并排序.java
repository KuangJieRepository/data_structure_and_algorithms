package com.kj.排序;

import java.util.Arrays;

/**
 * 1.找到中间索引，左边右边不断递归拆分。
 * 2.直到剩下2个元素，不在进行拆分。
 * 3.开始进行合并排序，使用 i j 两个指针 i<= mid j<= right 向有移动，将小的数放在临时数组 tmp 中
 *
 * @author kj
 * @date 2024/10/16
 */
public class MergeSort_归并排序 {
    public static void main(String[] args) {
        int[] arr1 = {6, 5, 4, 3, 2, 1};
        int[] tmp1 = new int[arr1.length];
        sort(arr1, 0, arr1.length - 1, tmp1);

        int[] arr2 = {5, 4, 3, 2, 1};
        int[] tmp2 = new int[arr1.length];
        sort(arr2, 0, arr2.length - 1, tmp2);

        System.out.println("arr1：：" + Arrays.toString(arr1));
        System.out.println("arr2：：" + Arrays.toString(arr2));
    }

    public static void sort(int[] arr, int left, int right, int[] tmp) {
        if (left < right) {
            int mid = (left + right) >> 1;
            // 拆分左边
            sort(arr, left, mid, tmp);
            // 拆分右边
            sort(arr, mid + 1, right, tmp);

            // 无法拆分后，开始归并
            merge(arr, left, right, mid, tmp);
        }
    }

    private static void merge(int[] arr, int left, int right, int mid, int[] tmp) {
        int i = left;
        int j = mid + 1;
        // 记录 tmp 数组的最新索引
        int t = 0;

        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                tmp[t] = arr[i];
                t++;
                i++;
            } else {
                tmp[t] = arr[j];
                t++;
                j++;
            }
        }

        while (i <= mid) {
            tmp[t] = arr[i];
            t++;
            i++;
        }
        while (j <= right) {
            tmp[t] = arr[j];
            t++;
            j++;
        }

        // 将排序后的元素放回到 arr 中
        t = 0;
        while (left <= right) {
            arr[left] = tmp[t];
            left++;
            t++;
        }
    }
}
