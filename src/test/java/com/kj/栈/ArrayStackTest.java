package com.kj.栈;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStackTest {

    private ArrayStack stack;

    @BeforeEach
    void setUp() {
        stack = new ArrayStack(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
    }

    @Test
    void size() {
        System.out.println(stack.size());
    }

    @Test
    void push() {
        stack.push(4);
    }

    @Test
    void clear() {
        stack.clear();

        System.out.println(stack.size());

        stack.show();
    }

    @Test
    void pop() {
        int pop = stack.pop();
        System.out.println("pop:" + pop);

        stack.show();
    }
}