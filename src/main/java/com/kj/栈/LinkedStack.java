package com.kj.栈;

import java.util.Iterator;

/**
 * 基于链表实现
 *
 * @author kj
 * @date 2024/10/17
 */
public class LinkedStack<T> implements Iterable {
    private Node head;
    private int size;

    public LinkedStack() {
        head = new Node(null, null);
        size = 0;
    }

    public void clear() {
        head.next = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void push(T t) {
        Node node = new Node(t, head.next);
        head.next = node;
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }

        Node pop = head.next;
        head.next = head.next.next;
        size--;
        return pop.item;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private Node node = head;

            @Override
            public boolean hasNext() {
                return node.next != null;
            }

            @Override
            public Object next() {
                node = node.next;
                return node.item;
            }
        };
    }

    private class Node {
        private final T item;
        private Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
}
