package com.kj.search;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

@Slf4j
class BinarySearchTest {

    /**
     * 二分查找-基础版
     */
    @Test
    void search() {
        int[] a = new int[]{2, 5, 7, 8, 10, 33};

        int search = BinarySearch.search(a, 33);

        log.debug("{}", search);
    }

    /**
     * 二分查找-改动版
     */
    @Test
    void search2() {
        int[] a = new int[]{2, 5, 7, 8, 10, 33};

        int search = BinarySearch.search2(a, 33);

        log.debug("{}", search);
    }

    /**
     * 二分查找-java工具
     */
    @Test
    void search3() {
        int[] a = new int[]{2, 5, 7, 8, 10, 33};
        int target = 35;

        int search = Arrays.binarySearch(a, target);

        log.debug("{}", search);

        int insertIndex = -(search + 1);

        log.debug("要插入的索引位置，加1在取反：{}", insertIndex);
    }

    /**
     * 二分查找-平衡版
     */
    @Test
    void t4() {
        int[] a = new int[]{2, 5, 7, 8, 10, 33};
        int target = 7;

        int search = BinarySearch.search3(a, target);

        log.debug("{}", search);
    }

    /**
     * 二分查找-leftmost
     */
    @Test
    void search4() {
        int[] a = new int[]{2, 5, 7, 7, 7, 8, 10, 33};
        int target = 7;

        int search = BinarySearch.search4(a, target);

        log.debug("{}", search);
    }

    /**
     * 二分查找-leftmost-改版
     */
    @Test
    void search4_1() {
        int[] nums = new int[]{2, 5, 7, 7, 7, 8, 10, 33};

        log.debug("{}", BinarySearch.search4_1(nums, 7));
        log.debug("{}", BinarySearch.search4_1(nums, 3));
    }

    /**
     * 二分查找-rightmost
     */
    @Test
    void search5() {
        int[] nums = new int[]{2, 5, 7, 7, 7, 8, 10, 33};

        log.debug("{}", BinarySearch.search5(nums, 3));
        log.debug("{}", BinarySearch.search5(nums, 34));
    }

    /**
     * 二分查找-rightmost-改版
     */
    @Test
    void search5_1() {
        int[] nums = new int[]{2, 5, 7, 7, 7, 8, 10, 33};

        log.debug("{}", BinarySearch.search5_1(nums, 3));
        log.debug("{}", BinarySearch.search5_1(nums, 34));
    }
}