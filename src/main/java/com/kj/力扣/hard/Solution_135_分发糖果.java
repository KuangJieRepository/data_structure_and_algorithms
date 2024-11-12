package com.kj.力扣.hard;

import java.util.Arrays;

class Solution_135_分发糖果 {
    public static void main(String[] args) {

    }

    static class Solution {
        public int candy(int[] ratings) {
            int n = ratings.length;
            int[] left = new int[n];
            int[] right = new int[n];

            Arrays.fill(left, 1);
            Arrays.fill(right, 1);

            for (int i = 1; i < n; i++) {
                if (ratings[i] > ratings[i - 1]) {
                    left[i] = left[i - 1] + 1;
                }
            }

            int sum = left[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                if (ratings[i] > ratings[i + 1]) {
                    right[i] = right[i + 1] + 1;
                }
                sum += Math.max(left[i], right[i]);
            }

            return sum;
        }
    }
}