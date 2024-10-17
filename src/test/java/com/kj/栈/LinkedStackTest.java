package com.kj.栈;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedStackTest {

    private LinkedStack<String> stack;

    @BeforeEach
    void setUp() {
        stack = new LinkedStack<>();
    }

    @Test
    void isEmpty() {
        stack.push("1");

        System.out.println(stack.isEmpty());
    }

    @Test
    void size() {
        stack.push("1");
        System.out.println(stack.size());

        stack.clear();
        System.out.println(stack.size());
    }

    @Test
    void push() {
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");

        for (Object o : stack) {
            System.out.println(o);
        }
    }

    @Test
    void pop() {
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");

        stack.pop();

        for (Object o : stack) {
            System.out.println(o);
        }
    }
}