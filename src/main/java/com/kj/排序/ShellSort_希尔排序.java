package com.kj.排序;

import java.util.Arrays;

/**
 * 插入排序的进阶版
 * 先大步长排序，再小步长排序，减少元素交换的次数，不断的对步长进行缩小，直至步长=1
 *
 * @author kj
 * @date 2024/10/16
 */
public class ShellSort_希尔排序 {
    public static void main(String[] args) {
        int[] arr1 = {6, 5, 4, 3, 2, 1};
        sort(arr1);

        int[] arr2 = {5, 4, 3, 2, 1};
        sort(arr2);

        System.out.println("arr1：：" + Arrays.toString(arr1));
        System.out.println("arr2：：" + Arrays.toString(arr2));
    }

    public static void sort(int[] arr) {
        // 确定步长
        int gap = arr.length;
        while (gap > 1) {
            gap >>= 1;
            shellSort(arr, gap);
        }
    }

    // 通过步长，获取自己组内的数据，进行插入排序
    private static void shellSort(int[] arr, int gap) {
        for (int i = gap; i < arr.length; i++) {
            for (int j = i - gap; j >= 0; j -= gap) {
                // 不能拿 i 进行比较，需要使用 j+gap
                // 因为 j 是每次向前变化的，j+gap 才是同一分组下的相邻的下一个元素
                if (arr[j] > arr[j + gap]) {
                    int tmp = arr[j + gap];
                    arr[j + gap] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }
}
