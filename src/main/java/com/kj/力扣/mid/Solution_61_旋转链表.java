package com.kj.力扣.mid;

class Solution_61_旋转链表 {
    public static void main(String[] args) {

    }

    static class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || head.next == null) return head;

            int len = 0;
            ListNode cur = head;
            ListNode tail = null;

            // 寻找尾节点
            while (cur != null) {
                len++;
                if (cur.next == null) {
                    tail = cur;
                }
                cur = cur.next;
            }

            k %= len;
            if (k == len) return head;

            tail.next = head;

            // 将 tail 节点，移动至新的尾结点
            for (int i = 0; i < len - k; i++) {
                tail = tail.next;
            }
            // 断开新尾结点和后边节点的链接
            head = tail.next;
            tail.next = null;

            return head;
        }
    }

    static public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}