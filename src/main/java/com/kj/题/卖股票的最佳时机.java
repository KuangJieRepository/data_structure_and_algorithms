package com.kj.题;

/**
 *
 *
 * @author kj
 * @date 2024/11/6
 */
public class 卖股票的最佳时机 {
    public static void main(String[] args) {
        int[] arr = new int[]{7, 1, 5, 3, 6, 4};

        System.out.println(maxValue(arr));
    }

    public static int maxValue(int[] arr) {
        if (arr == null || arr.length <= 1) return 0;

        int min = arr[0];
        int maxDiff = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            } else {
                maxDiff = Math.max(maxDiff, arr[i] - min);
            }
        }

        return maxDiff;
    }
}
