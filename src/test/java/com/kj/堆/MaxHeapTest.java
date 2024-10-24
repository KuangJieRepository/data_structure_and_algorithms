package com.kj.堆;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MaxHeapTest {

    private MaxHeap<Integer> maxHeap = new MaxHeap<>(10);

    @BeforeEach
    void beforeEach() {
        maxHeap.insert(3);
        maxHeap.insert(9);
        maxHeap.insert(6);
    }

    @Test
    void delMax() {
        maxHeap.delMax();

        maxHeap.show();
    }

    @Test
    void insert() {
        maxHeap.insert(1);

        maxHeap.show();
    }
}