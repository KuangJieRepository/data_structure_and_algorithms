package com.kj.力扣.easy;

class Solution_190_颠倒二进制位 {
    public static void main(String[] args) {

    }

    static class Solution {
        public int reverseBits(int n) {
            int ans = 0;

            for (int i = 0; i < 32; i++) {
                int bit = (n >> i) & 1;
                ans = ans | (bit << (31 - i));
            }

            return ans;
        }
    }
}