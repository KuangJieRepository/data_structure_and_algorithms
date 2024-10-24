package com.kj.堆;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MinHeapTest {

    private MinHeap<Integer> minHeap = new MinHeap<>(10);

    @BeforeEach
    void beforeEach() {
        minHeap.insert(3);
        minHeap.insert(9);
        minHeap.insert(6);
    }

    @Test
    void delMax() {
        minHeap.delMin();

        minHeap.show();
    }

    @Test
    void insert() {
        minHeap.insert(1);

        minHeap.show();
    }
}