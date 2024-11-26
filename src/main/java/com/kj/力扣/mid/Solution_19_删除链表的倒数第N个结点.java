package com.kj.力扣.mid;

class Solution_19_删除链表的倒数第N个结点 {
    public static void main(String[] args) {

    }

    static class Solution {
        int count = 0;

        public ListNode removeNthFromEnd(ListNode head, int n) {

            if (head == null) {
                return head;
            }
            head.next = removeNthFromEnd(head.next, n);

            return ++count == n ? head.next : head;
        }
    }

    public class ListNode {
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