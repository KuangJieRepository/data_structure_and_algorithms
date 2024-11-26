package com.kj.力扣.easy;

class Solution_191_位1的个数 {
    public static void main(String[] args) {

    }

    static class Solution {
        public int hammingWeight(int n) {
            int ans = 0;
            while (n > 0) {
                if ((n & 1) == 1) ans++;
                n >>= 1;
            }

            return ans;
        }
    }
}