package com.kj.排序;

import java.util.Arrays;

/**
 *
 *
 * @author kj
 * @date 2024/10/14
 */
public class BubbleSort_冒泡排序 {
    public static void main(String[] args) {
        int[] arr1 = {6, 5, 4, 3, 2, 1};
        sort(arr1);

        int[] arr2 = {5, 4, 3, 2, 1};
        sort(arr2);

        System.out.println("arr1：：" + Arrays.toString(arr1));
        System.out.println("arr2：：" + Arrays.toString(arr2));
    }

    /**
     * 冒泡排序
     */
    private static void sort(int[] arr) {
        int tmp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    /**
     * 改进-提前结束比较
     */
    private static void sort2(int[] arr) {
        int tmp;
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;

                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }
}
