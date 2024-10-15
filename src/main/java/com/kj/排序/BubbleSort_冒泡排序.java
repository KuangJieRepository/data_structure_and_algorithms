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
        int[] arr = {1314, 82, 50, 21, 5, 66, 48, 43, 79, 14, 37, 25};
        System.out.println(Arrays.toString(sort(arr)));
        System.out.println(Arrays.toString(sort2(arr)));
    }

    /**
     * 冒泡排序
     */
    private static int[] sort(int[] arr) {
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
        return arr;
    }

    /**
     * 改进-提前结束比较
     */
    private static int[] sort2(int[] arr) {
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
        return arr;
    }
}
