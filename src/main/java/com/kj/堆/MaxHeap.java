package com.kj.堆;

/**
 * 最大堆
 * 最大优先队列
 */
public class MaxHeap<T extends Comparable<T>> {
    /**
     * 用来存储元素的数组
     */
    private T[] items;
    /**
     * 记录堆中元素的个数
     */
    private int size;

    /**
     * 创建容量为capacity的Heap对象
     *
     * @param capacity 堆的容量
     */
    public MaxHeap(int capacity) {
        // 初始化操作
        items = (T[]) new Comparable[capacity + 1];
        size = 0;
    }

    /**
     * 判断堆中索引i处的元素是否小于索引j处的元素
     *
     * @param i 索引i
     * @param j 索引j
     * @return 如果索引i处的元素小于索引j处的元素，则返回true，否则返回false
     */
    private boolean less(int i, int j) {
        return items[i].compareTo(items[j]) < 0;
    }

    /**
     * 交换堆中i索引和j索引处的值
     *
     * @param i 索引i
     * @param j 索引j
     */
    private void exch(int i, int j) {
        // 实现交换逻辑
        T tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;
    }

    /**
     * 删除堆中最大的元素，并返回这个最大元素
     *
     * @return 被删除的最大元素
     */
    public T delMax() {
        T max = items[1];

        // 将最大元素和最后一个元素进行交换
        exch(1, size);

        // 将最后一个元素清空
        items[size--] = null;

        // 调整堆的状态
        sink(1);

        return max;
    }

    /**
     * 往堆中插入一个元素
     *
     * @param t 要插入的元素
     */
    public void insert(T t) {
        items[++size] = t;
        // 对堆的状态进行调整
        swim(size);
    }

    /**
     * 使用上浮算法，使索引k处的元素能在堆中处于一个正确的位置
     *
     * 将插入在最后的一个数据向上进行调整
     *
     * @param k 索引k
     */
    private void swim(int k) {
        while (k > 1) {
            if (less(k >> 1, k)) {
                exch(k >> 1, k);
            } else {
                break;
            }

            k >>= 1;
        }
    }

    /**
     * 使用下沉算法，使索引k处的元素能在堆中处于一个正确的位置
     *
     * 将第一个元素向下放置合适的位置
     *
     * @param k 索引k
     */
    private void sink(int k) {
        while (k * 2 <= size) {
            int maxIndex;
            if (items[k * 2 + 1] != null) {
                // 有右节点
                maxIndex = less(k * 2, k * 2 + 1) ? k * 2 + 1 : k * 2;
            } else {
                // 无右节点
                maxIndex = k * 2;
            }

            if (!less(k, maxIndex)) {
                // 不小于子节点，就是合适的位置
                break;
            }

            exch(k, maxIndex);

            k = maxIndex;
        }
    }

    public void show() {
        for (int i = 1; i <= size; i++) {
            System.out.print(items[i] + " ");
        }
    }
}