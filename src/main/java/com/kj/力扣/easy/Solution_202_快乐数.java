package com.kj.力扣.easy;

import java.util.HashSet;
import java.util.Set;

class Solution_202_快乐数 {
    public static void main(String[] args) {

    }

    static class Solution {
        Set<Integer> set = new HashSet<>();

        public boolean isHappy(int n) {
            while (true) {
                n = calcSum(n);
                if (n == 1) return true;
                if (set.contains(n)) return false;
                set.add(n);
            }
        }

        /**
         * 求每位数字的平方和
         */
        public int calcSum(int n) {
            int sum = 0;

            while (n > 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }

            return sum;
        }
    }
}