package com.kj.树;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.tree.TreeCellRenderer;

class BinaryTreeTest {
    private BinaryTree<Integer, Integer> tree;

    @BeforeEach
    void beforeEach() {
        tree = new BinaryTree<>();
        tree.put(7, 7);
        tree.put(4, 4);
        tree.put(11, 11);
        tree.put(2, 2);
        tree.put(5, 5);
        tree.put(6, 6);
        tree.put(1, 1);
        tree.put(3, 3);
    }

    @Test
    void size() {

        // tree.delete(4);
        tree.delete(2);
        System.out.println(tree.size());
    }

    @Test
    void getMinKey() {
        System.out.println(tree.getMinKey());
    }

    @Test
    void getMaxKey() {
        System.out.println(tree.getMaxKey());
    }

    @Test
    void delete() {
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        tree.put(10, 10);
        tree.put(4, 4);
        tree.put(11, 11);
        tree.put(2, 2);
        tree.put(8, 8);
        tree.put(1, 1);
        tree.put(3, 3);
        tree.put(7, 7);
        tree.put(9, 9);

        tree.delete(4);

        System.out.println(tree.size());
    }

    @Test
    void preOrder() {
        tree.preOrder();
    }

    @Test
    void midOrder() {
        tree.midOrder();
    }

    @Test
    void suffixOrder() {
        tree.suffixOrder();
    }
}