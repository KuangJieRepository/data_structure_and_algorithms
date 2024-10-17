package com.kj.linked;

import java.util.Iterator;

/**
 * 单向链表实现
 *
 * @author kj
 * @date 2024/10/17
 */
public class LinkList<T> implements Iterable<T> {

    // 头节点
    private final Node head;

    private int size;

    public LinkList() {
        head = new Node(null, null);
        size = 0;
    }

    public int size() {
        return size;
    }

    /**
     * 插入数据
     */
    public void insert(T t) {
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = new Node(t, null);
        size++;
    }

    public void reverse() {
        if (size <= 0) {
            return;
        }
        // reverse(head.next);
        reverse2(head.next);
    }

    /**
     * 反转链表
     */
    private Node reverse(Node curr) {
        if (curr.next == null) {
            head.next = curr;
            return curr;
        }

        Node reverse = reverse(curr.next);

        reverse.next = curr;

        curr.next = null;

        return curr;
    }

    /**
     * 反转链表
     */
    private Node reverse2(Node curr) {
        if (curr.next == null) {
            head.next = curr;
            return curr;
        }

        Node reverse = reverse2(curr.next);

        curr.next.next = curr;
        curr.next = null;

        // 返回的是反转后的第一个节点
        return reverse;
    }

    /**
     * 获取中间值
     *
     * @return 值
     */
    public T getMid() {
        if (size == 0 || head.next == null) {
            return null;
        }

        Node slow = head.next;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {
        private Node node;

        public MyIterator() {
            this.node = head;
        }

        @Override
        public boolean hasNext() {
            return node.next != null;
        }

        @Override
        public T next() {
            node = node.next;
            return node.item;
        }
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
