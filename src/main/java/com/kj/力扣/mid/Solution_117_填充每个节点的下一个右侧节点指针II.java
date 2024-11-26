package com.kj.力扣.mid;

class Solution_117_填充每个节点的下一个右侧节点指针II {
    public static void main(String[] args) {

    }

    /**
     * 就是层序遍历
     */
    static class Solution {
        public Node connect(Node root) {
            if (root == null) return root;

            Node parent = root;
            // child 指向的是每一层的最左侧的节点
            Node child = root.left != null ? root.left : root.right;

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