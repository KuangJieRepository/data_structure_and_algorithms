package com.kj.题;

/**
 *
 *
 * @author kj
 * @date 2024/10/30
 */
public class RemoveLinkedElement_移除链表中的元素 {

    public static void main(String[] args) {
        Node n1 = new Node(1, null);
        Node n2 = new Node(2, null);
        Node n3 = new Node(3, null);
        Node n4 = new Node(4, null);
        Node n5 = new Node(2, null);
        Node n6 = new Node(2, null);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        Node remove = new RemoveLinkedElement_移除链表中的元素().remove(n1, 2);

        System.out.println(remove);
    }

    public Node remove(Node node, int remove) {
        if (node == null) {
            return null;
        }
        Node head = new Node(-1, null);
        Node tail = head;

        while (node != null) {
            if (node.item != remove) {
                // 这个元素是符合的，捡出来放入新链表中
                tail.next = node;
                tail = node;
            }
            node = node.next;
        }

        tail.next = null;

        return head.next;
    }

    private static class Node {
        private final int item;
        private Node next;

        public Node(int item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
}
