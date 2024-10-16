package com.kj.排序;

import java.util.Arrays;

/**
 * 核心思想：
 * 选择 n-1 轮，因为最后一轮只剩一个元素，无需进行判断
 * 1.每一轮选择出最小的元素的索引
 * 2.如果这个最小索引等于循环的变量索引，说明自己就是最小的，无需交换
 * 3.如果不是，将两个索引的数据进行交换
 *
 * @author kj
 * @date 2024/10/16
 */
public class SelectSort_选择排序 {
    public static void main(String[] args) {
        int[] arr = {1314, 82, 50, 21, 5, 66, 48, 43, 79, 14, 37, 25};

        sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                int tmp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = tmp;
            }
        }
    }
}
