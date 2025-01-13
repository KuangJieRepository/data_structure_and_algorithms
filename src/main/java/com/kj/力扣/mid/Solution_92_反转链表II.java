package com.kj.力扣.mid;

class Solution_92_反转链表II {
    public static void main(String[] args) {

    }

    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode dummy = new ListNode(0, head);
            ListNode pre = dummy;

            for (int i = 0; i < left - 1; i++) {
                pre = pre.next;
            }

            ListNode cur = pre.next;

            for (int i = 0; i < right - left; i++) {
                ListNode node = cur.next;

                cur.next = node.next;

                node.next = pre.next;
                pre.next = node;
            }

            return dummy.next;
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