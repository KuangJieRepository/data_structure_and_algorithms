package com.kj.力扣.easy;

class Solution_141_环形链表 {
    public static void main(String[] args) {

    }

    /**
     * 快慢指针
     */
    static class Solution {

        public boolean hasCycle(ListNode head) {
            if (head == null)
                return false;

            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast)
                    return true;
            }

            return false;
        }
    }

    static class ListNode {
        ListNode next;
    }
}