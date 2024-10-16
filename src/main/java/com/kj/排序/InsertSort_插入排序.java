package com.kj.排序;

import java.util.Arrays;

/**
 * 核心思想：
 * 从第二个元素开始，和他右边的每个元素进行比较，如果小于的话，插入他的前边，也就是进行交换
 *
 * @author kj
 * @date 2024/10/16
 */
public class InsertSort_插入排序 {
    public static void main(String[] args) {
        int[] arr1 = {6, 5, 4, 3, 2, 1};
        int[] arr2 = {5, 4, 3, 2, 1};

        sort(arr1);
        sort(arr2);

        System.out.println("arr1：：" + Arrays.toString(arr1));
        System.out.println("arr2：：" + Arrays.toString(arr2));
    }

    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j >= 1; j--) {
                if (arr[j] < arr[j - 1]) {
                    int tmp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }
}
