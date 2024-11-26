package com.kj.力扣.mid;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

class Solution_138_随机链表的复制 {
    public static void main(String[] args) {

    }

    static class Solution {
        public Node copyRandomList(Node head) {
            // 存储老节点和新节点的映射
            Map<Node, Node> map = new HashMap<>();

            // 存储映射
            Node cur = head;
            while (cur != null) {
                Node newNode = new Node(cur.val);
                map.put(cur, newNode);
                cur = cur.next;
            }

            cur = head;
            while (cur != null) {
                Node newNode = map.get(cur);
                newNode.next = map.get(cur.next);
                newNode.random = map.get(cur.random);
                cur = cur.next;
            }

            return map.get(head);
        }
    }

    @Data
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}