package com.kj.array;

import java.util.function.IntConsumer;

/**
 * @Description 动态数组
 * @Author kj
 * @Date 2024/3/26
 */
public class DynamicArray {
    /**
     * 真实数据个数
     */
    private int size;
    /**
     * 容量
     */
    private int capacity = 10;
    /**
     * 数组
     */
    private int[] array;

    /**
     * 添加元素
     *
     * @param index 索引
     * @param element 元素
     */
    public void add(int index, int element) {
        this.checkAndGrow();

        checkIndex(index);

        if (index == size) {
            array[size] = element;
        } else {
            System.arraycopy(array, index, array, index + 1, size - index);
            array[index] = element;
        }
        size++;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("invalid index");
        }
    }

    /**
     * 添加末尾
     * @param element 元素
     */
    public void addLast(int element) {
        add(size, element);
    }

    /**
     * 扩容
     */
    public void checkAndGrow() {
        if (size == 0) {
            array = new int[capacity];
        } else if (size == capacity) {
            capacity += capacity >> 1;
            int[] newArray = new int[capacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }

    public int get(int index) {
        checkIndex(index);

        return array[index];
    }

    /**
     * 移除元素
     *
     * @param index [0,size)
     */
    public int remove(int index) {
        int remove = array[index];

        if (index < size - 1) {
            System.arraycopy(array, index + 1, array, index, size - index - 1);
        }
        size--;
        return remove;
    }

    public void foreach(IntConsumer intConsumer) {
        for (int i = 0; i < size; i++) {
            intConsumer.accept(array[i]);
        }
    }
}
