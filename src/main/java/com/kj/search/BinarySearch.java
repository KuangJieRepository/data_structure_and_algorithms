package com.kj.search;

/**
 * @Description 二分法查找
 * @Author kj
 * @Date 2024/3/15
 */
public class BinarySearch {

    /**
     * 二分查找-基础版
     * <p>
     * i <= j，不加 = 会漏掉 i=j 时的一次比较
     * <p>
     * m 中间元素索引，向下取整
     * <p>
     * i+j 可能会超出 int 的数据最大值，出现负数的情况。 使用 >>> 无符号右移操作。
     * <p>
     *
     * @param a  【有序】【递增】数据
     * @param target 目标值
     * @return 索引
     */
    public static int search(int[] a, int target) {
        int i = 0, j = a.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m - 1;
            } else if (a[m] < target) {
                i = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    /**
     * 改动版
     * <p>
     * j 指向的元素，不是想要继续比较的元素
     * <p>
     * 改动 1：j = a.length
     * <p>
     * 改动 2：while (i < j)
     * <p>
     * 改动 3：j = m;
     */
    public static int search2(int[] a, int target) {
        int i = 0, j = a.length;
        while (i < j) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m;
            } else if (a[m] < target) {
                i = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    /**
     * 二分查找——平衡版
     */
    public static int search3(int[] nums, int target) {
        int i = 0, j = nums.length;
        while (1 < j - i) {
            int m = (i + j) >>> 1;
            if (target < nums[m]) {
                j = m;
            } else {
                i = m;
            }
        }
        return nums[i] == target ? i : -1;
    }

    /**
     * leftmost
     * 查找最左边的符合的索引
     * <p>
     * candidate:记录候选值,在向左或者向右继续查找是否有符合的数据
     */
    public static int search4(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        int candidate = -1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < nums[m]) {
                j = m - 1;
            } else if (nums[m] < target) {
                i = m + 1;
            } else {
                candidate = m;
                j = m - 1;
            }
        }
        return candidate;
    }

    /**
     * leftmost - 改版
     * <p>
     * 返回查找的元素的索引或者，要插入的索引位置
     * <p>
     *  ≥ target 的最左边的位置
     */
    public static int search4_1(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target <= nums[m]) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return i;
    }

    /**
     * rightmost
     * <p>
     * 查找最右边的符合的索引
     * <p>
     * 与leftmost的差距：left是向左缩小 j 的范围。right 是向右扩大 i 的范围
     */
    public static int search5(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        int candidate = -1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < nums[m]) {
                j = m - 1;
            } else if (nums[m] < target) {
                i = m + 1;
            } else {
                candidate = m;
                i = m + 1;
            }
        }
        return candidate;
    }

    /**
     * rightmost - 改版
     * <p> 返回查找的元素的索引或者，要插入的索引位置
     * <p> ≤ target 的最右边的位置
     */
    public static int search5_1(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < nums[m]) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return i - 1;
    }
}
