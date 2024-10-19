package com.kj.栈;

/**
 * 基于数组实现
 *
 * @author kj
 * @date 2024/10/17
 */
public class ArrayStack<T> {
    private Object[] arr;
    private int maxStack;
    private int top = -1;

    public ArrayStack(int maxStack) {
        this.maxStack = maxStack;
        arr = new Object[maxStack];
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

    /**
     * 判断小括号 ( 是否匹配
     *
     * @param str 内容
     * @return 是否
     */
    public static boolean isMatch(String str) {
        ArrayStack<String> stack = new ArrayStack<>(str.length());
        for (char c : str.toCharArray()) {
            String ch = c + "";
            if ("(".equals(ch)) {
                stack.push(ch);
            }
            if (")".equals(ch)) {
                String pop = stack.pop();
                if (pop == null) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public void push(Object val) {
        if (isFull()) {
            throw new IllegalArgumentException("栈满");
        }

        arr[++top] = val;
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }

        return (T) arr[top--];
    }

    /**
     * 查看栈顶元素
     *
     * @return 值
     */
    public T peek() {
        return (T) arr[top];
    }

    public void show() {
        if (isEmpty()) {
            return;
        }
        System.out.println("======start======");
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%s]:%s\n", i, arr[i]);
        }
        System.out.println("=======end=======");
    }
}
