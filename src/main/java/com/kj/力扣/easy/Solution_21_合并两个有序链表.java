package com.kj.力扣.easy;

import lombok.Data;

class Solution_21_合并两个有序链表 {
    public static void main(String[] args) {

    }

    static class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode dum = new ListNode();
            ListNode cur = dum;
            while (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    cur.next = list1;
                    list1 = list1.next;
                } else {
                    cur.next = list2;
                    list2 = list2.next;
                }
                cur = cur.next;
            }

            cur.next = list1 != null ? list1 : list2;

            return dum.next;
        }
    }

    @Data
    static class ListNode {
        int val;
        ListNode next;
    }
}