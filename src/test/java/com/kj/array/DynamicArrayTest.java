package com.kj.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DynamicArrayTest {

    private DynamicArray dynamicArray = new DynamicArray();

    @BeforeEach
    void init() {
        dynamicArray.add(0, 1);
        dynamicArray.add(1, 2);
    }

    @Test
    void add() {
        dynamicArray.add(2, 3);
        dynamicArray.add(3, 4);
        dynamicArray.foreach(System.out::println);
    }

    @Test
    void addLast() {
        dynamicArray.add(0, 2);
        dynamicArray.add(1, 3);

        dynamicArray.addLast(4);
        dynamicArray.foreach(System.out::println);
    }

    @Test
    void get() {
        System.out.println(dynamicArray.get(1));
    }

    @Test
    void remove() {
        System.out.println(dynamicArray.remove(0));
        dynamicArray.foreach(System.out::println);
    }
}