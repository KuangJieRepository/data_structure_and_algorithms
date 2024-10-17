package com.kj.linked;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkListTest {

    private LinkList<String> list;

    @BeforeEach
    public void init() {
        list = new LinkList<>();
        list.insert("1");
        list.insert("2");
        list.insert("3");
        list.insert("4");
    }

    @Test
    void reverse() {
        list.reverse();

        for (String s : list) {
            System.out.println(s);
        }
    }

    @Test
    void getMid() {
        String mid = list.getMid();

        System.out.println(mid);
    }

    @Test
    void circle() {
        CircleNode n1 = new CircleNode(1, null);
        CircleNode n2 = new CircleNode(2, null);
        CircleNode n3 = new CircleNode(3, null);
        CircleNode n4 = new CircleNode(4, null);
        CircleNode n5 = new CircleNode(5, null);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        n5.next = n2;

        boolean circle = isCircle(n1);

        System.out.println(circle);
    }

    /**
     * 快慢指针判断是否有环形的存在
     *
     * 并不是说这个链表就是一个环形链表
     *
     * @param first 头节点
     * @return 是否
     */
    public boolean isCircle(CircleNode first) {

        CircleNode slow = first;
        CircleNode fast = first;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast.equals(slow)) {
                return true;
            }
        }

        return false;
    }

    private static class CircleNode {
        private final Object item;
        private CircleNode next;

        public CircleNode(Object item, CircleNode next) {
            this.item = item;
            this.next = next;
        }
    }
}