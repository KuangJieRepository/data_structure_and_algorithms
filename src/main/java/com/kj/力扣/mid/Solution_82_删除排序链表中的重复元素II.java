package com.kj.力扣.mid;

class Solution_82_删除排序链表中的重复元素II {
    public static void main(String[] args) {

    }

    static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode dummy = new ListNode(0, head);
            ListNode cur = dummy;
            int v;
            while (cur.next != null && cur.next.next != null) {
                if (cur.next.val == cur.next.next.val) {
                    v = cur.next.val;

                    while (cur.next != null && cur.next.val == v) {
                        cur.next = cur.next.next;
                    }
                } else {
                    cur = cur.next;
                }
            }

            return dummy.next;
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