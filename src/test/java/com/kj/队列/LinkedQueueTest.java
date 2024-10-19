package com.kj.队列;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedQueueTest {
    private LinkedQueue<String> queue;

    @BeforeEach
    void setUp() {
        queue = new LinkedQueue<>();
        queue.enQueue("1");
        queue.enQueue("2");
        queue.enQueue("3");
    }

    @Test
    void isEmpty() {
        System.out.println(queue.isEmpty());
    }

    @Test
    void size() {
        System.out.println(queue.size());

        queue.print();
    }

    @Test
    void enQueue() {
        queue.enQueue("4");

        System.out.println(queue.size());

        queue.print();
    }

    @Test
    void delQueue() {
        System.out.println(queue.delQueue());
        System.out.println(queue.delQueue());
        System.out.println(queue.delQueue());

        System.out.println(queue.size());
    }
}