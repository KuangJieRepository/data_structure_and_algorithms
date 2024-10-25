package com.kj.队列;

import java.util.Iterator;

/**
 * 基于链表实现队列
 * 先进先出，后进后出
 *
 * @author kj
 * @date 2024/10/18
 */
public class LinkedQueue<T> implements Iterable<T> {

    private Node head;
    private Node last;
    private int size;

    public LinkedQueue() {
        head = new Node(null, null);
        last = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public T delQueue() {
        if (isEmpty()) {
            return null;
        }

        Node node = head.next;

        head.next = node.next;

        size--;

        return node.item;
    }

    public void enQueue(T t) {
        Node node = new Node(t, null);
        if (last == null) {
            last = node;
            head.next = last;
        } else {
            last.next = node;
            last = node;
        }

        size++;
    }

    public void print() {
        for (T t : this) {
            System.out.println(t);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator() {
            private Node node = head;

            @Override
            public boolean hasNext() {
                return node.next != null;
            }

            @Override
            public T next() {
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
