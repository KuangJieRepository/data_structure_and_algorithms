package com.kj.力扣.mid;

class Solution_116_填充每个节点的下一个右侧节点指针 {
    public static void main(String[] args) {

    }

    /**
     * 就是层序遍历
     */
    static class Solution {
        public Node connect(Node root) {
            if (root == null) return root;

            Node parent = root;
            Node child = root.left;

            while (child != null) {
                while (parent != null) {
                    parent.left.next = parent.right;
                    if (parent.next != null) {
                        // 说明存在同级的右侧节点
                        parent.right.next = parent.next.left;
                    }
                    parent = parent.next;
                }
                parent = child;
                child = child.left;
            }

            return root;
        }
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}