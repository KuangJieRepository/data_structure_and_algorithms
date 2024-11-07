package com.kj.力扣.easy;

class Solution_121_买卖股票的最佳时机 {
    public static void main(String[] args) {
        int[] p = new int[]{7, 1, 5, 3, 6, 4};

        System.out.println(new Solution().maxProfit(p));
    }

    static class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length <= 1) return 0;
            int maxPrice = 0;
            int min = prices[0];

            for (int i = 1; i < prices.length; i++) {
                if (prices[i] < min) {
                    min = prices[i];
                } else {
                    maxPrice = Math.max(maxPrice, prices[i] - min);
                }
            }

            return maxPrice;
        }
    }
}