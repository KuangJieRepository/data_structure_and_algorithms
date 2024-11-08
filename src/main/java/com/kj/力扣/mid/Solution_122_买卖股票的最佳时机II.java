package com.kj.力扣.mid;

class Solution_122_买卖股票的最佳时机II {
    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};

        System.out.println(new Solution().maxProfit(prices));
    }

    static class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null) return 0;

            // 贪心的思想？？ 只要能赚，我就操作
            // 动态规划听不懂。。。
            int ans = 0;
            for (int i = 0; i < prices.length - 1; i++) {
                if (prices[i + 1] > prices[i]) {
                    ans += (prices[i + 1] - prices[i]);
                }
            }

            return ans;
        }
    }
}