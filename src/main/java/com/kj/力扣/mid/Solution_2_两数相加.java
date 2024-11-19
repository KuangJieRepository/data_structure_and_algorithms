package com.kj.力扣.mid;

import lombok.Data;

class Solution_2_两数相加 {
    public static void main(String[] args) {
        Long a = Long.parseLong("9999999991");
    }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(0);
            ListNode tail = dummy;
            // 进位
            int carry = 0;

            while (l1 != null || l2 != null || carry > 0) {
                int v1 = 0, v2 = 0;
                if (l1 != null) {
                    v1 = l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    v2 = l2.val;
                    l2 = l2.next;
                }
                int res = v1 + v2 + carry;
                int newVal = res % 10;

                tail.next = new ListNode(newVal);
                tail = tail.next;

                // 进位
                carry = res / 10;
            }

            return dummy.next;
        }
    }

    @Data
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}