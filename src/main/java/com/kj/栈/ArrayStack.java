package com.kj.栈;

/**
 * 基于数组实现
 *
 * @author kj
 * @date 2024/10/17
 */
public class ArrayStack {
    private int[] arr;
    private int maxStack;
    private int top = -1;

    public ArrayStack(int maxStack) {
        this.maxStack = maxStack;
        arr = new int[maxStack];
    }

    public void clear() {
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxStack - 1;
    }

    public int size() {
        return top + 1;
    }

    public void push(int val) {
        if (isFull()) {
            throw new IllegalArgumentException("栈满");
        }

        arr[++top] = val;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalArgumentException("空栈");
        }

        return arr[top--];
    }

    public void show() {
        if (isEmpty()) {
            return;
        }

        for (int i = 0; i <= top; i++) {
            System.out.printf("stack[%d]:%d\n", i, arr[i]);
        }
    }
}
