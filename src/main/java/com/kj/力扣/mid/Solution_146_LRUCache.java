package com.kj.力扣.mid;

import java.util.HashMap;
import java.util.Map;

class Solution_146_LRUCache {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        lruCache.put(4, 4);

        System.out.println(lruCache.get(1));
    }

    /**
     * LRU (Least Recently Used)
     * 最近最久未使用
     */
    static class LRUCache {
        private Map<Integer, Node> map;
        private int capacity;
        private Node first = new Node();
        private Node last = new Node();

        public LRUCache(int capacity) {
            map = new HashMap<>(capacity);
            this.capacity = capacity;
            first.next = last;
            last.pre = first;
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node == null) {
                return -1;
            }

            remove(node);
            appendFirst(node);

            return node.value;
        }

        public void put(int key, int value) {
            Node node = map.get(key);
            if (node == null) {
                // 新增
                if (map.size() >= this.capacity) {
                    map.remove(last.pre.key);
                    remove(last.pre);
                }
                node = new Node(key, value);
                map.put(key, node);
            } else {
                // 更新
                node.value = value;
                remove(node);
            }

            appendFirst(node);
        }

        private void remove(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        private void appendFirst(Node node) {
            first.next.pre = node;
            node.next = first.next;

            first.next = node;
            node.pre = first;
        }

        class Node {
            private int key;
            private int value;
            private Node pre;
            private Node next;

            public Node() {
            }

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
    }
}