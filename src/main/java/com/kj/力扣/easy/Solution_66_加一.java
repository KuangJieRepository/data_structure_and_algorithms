package com.kj.力扣.easy;

class Solution_66_加一 {
    public static void main(String[] args) {

    }

    static class Solution {
        public int[] plusOne(int[] digits) {
            for (int i = digits.length - 1; i >= 0; i--) {
                digits[i]++;
                digits[i] = digits[i] % 10;
                if (digits[i] != 0) return digits;
            }

            int[] ans = new int[digits.length + 1];
            ans[0] = 1;
            return ans;
        }
    }
}