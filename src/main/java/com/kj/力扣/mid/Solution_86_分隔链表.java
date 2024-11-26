package com.kj.力扣.mid;

class Solution_86_分隔链表 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(2);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        System.out.println(new Solution().partition(n1, 3));
    }

    static class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode min = new ListNode();
            ListNode minTail = min;
            ListNode max = new ListNode();
            ListNode maxTail = max;

            while (head != null) {
                if (head.val < x) {
                    minTail.next = new ListNode(head.val);
                    minTail = minTail.next;
                } else {
                    maxTail.next = new ListNode(head.val);
                    maxTail = maxTail.next;
                }
                head = head.next;
            }

            minTail.next = max.next;

            return min.next;
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