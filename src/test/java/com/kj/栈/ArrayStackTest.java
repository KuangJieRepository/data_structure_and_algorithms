package com.kj.栈;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrayStackTest {

    private ArrayStack<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new ArrayStack<>(3);
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

    @Test
    void calc() {
        String express = "6-1-1+1-1";

        Calculator_计算器 calc = new Calculator_计算器(express.length());

        int res = calc.calc(express);

        System.out.println(res);
    }

    @Test
    void isMatch() {
        String s1 = "(不知火舞)222((李信))";
        String s2 = "(((不知火舞))";

        System.out.println(ArrayStack.isMatch(s1));
        System.out.println(ArrayStack.isMatch(s2));
    }
}