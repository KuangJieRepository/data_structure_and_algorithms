package com.kj.题;

import java.util.Arrays;

/**
 *
 *
 * @author kj
 * @date 2024/11/5
 */
public class MoveZero_移动零 {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 0, 3, 12};

        MoveZero_移动零 m = new MoveZero_移动零();
        m.moveZero2(arr);

        int[] arr2 = new int[]{1, 2, 3, 4, 5};

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
    }

    public void moveZero(int[] arr) {
        int cur = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[cur++] = arr[i];
            }
        }

        while (cur < arr.length) {
            arr[cur++] = 0;
        }
    }

    public void moveZero2(int[] arr) {
        if (arr == null) return;

        int cur = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) continue;
            if (cur == i) {
                cur++;
                continue;
            }

            arr[cur++] = arr[i];
            arr[i] = 0;
        }
    }

}
