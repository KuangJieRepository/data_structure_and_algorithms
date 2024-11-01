package com.kj.排序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 基数排序，桶子排序
 *
 * @author kj
 * @date 2024/10/14
 */
public class BasicSort_基数排序 {

    public static void main(String[] args) {
        int[] arr1 = {6, 5, 4, 3, 2, 1};
        sort(arr1);

        int[] arr2 = {5, 4, 3, 2, 1};
        sort(arr2);

        System.out.println("arr1：：" + Arrays.toString(arr1));
        System.out.println("arr2：：" + Arrays.toString(arr2));
    }

    /**
     * 基数排序
     *
     * @param arr 数据
     */
    private static void sort(int[] arr) {
        // 1.找到最大数
        int max = 0;
        for (int j : arr) {
            if (j > max) {
                max = j;
            }
        }
        // 2.计算出最大位数
        int maxDigit = String.valueOf(max).length();
        // 3.创建对应的桶
        List<List<Integer>> buckets = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            buckets.add(new ArrayList<>(arr.length));
        }
        // 4.每个位数进行排序
        int mold = 10;
        int div = 1;
        for (int i = 0; i < maxDigit; i++, mold *= 10, div *= 10) {
            // 获取当前位的数字
            for (int j : arr) {
                int num = j % mold / div;
                buckets.get(num).add(j);
            }
            // 将经过排序的数据拿出
            int index = 0;
            for (List<Integer> bucket : buckets) {
                for (Integer num : bucket) {
                    arr[index++] = num;
                }
                bucket.clear();
            }
        }
    }
}
