package com.kj.队列;

/**
 * 基于数组实现队列
 *
 * @author kj
 * @date 2024/10/18
 */
public class ArrayQueue<T> {
    private Object[] arr;
    private int maxSize;
    private int head;
    private int tail;
    private int size;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new Object[maxSize];
        head = -1;
        tail = -1;
        size = 0;
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        return size == maxSize;
    }

    public int size() {
        return size;
    }

    // public T delQueue() {
    //
    // }

    public void enQueue(T t) {

    }
}
