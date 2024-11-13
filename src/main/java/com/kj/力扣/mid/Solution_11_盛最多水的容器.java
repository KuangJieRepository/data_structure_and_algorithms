package com.kj.力扣.mid;

class Solution_11_盛最多水的容器 {
    public static void main(String[] args) {

    }

    static class Solution {
        public int maxArea(int[] height) {
            int l = 0;
            int r = height.length - 1;
            int maxL = 0;
            int maxR = 0;
            int ans = 0;
            while (l < r) {
                maxL = Math.max(maxL, height[l]);
                maxR = Math.max(maxR, height[r]);

                // 短板高度
                int h = Math.min(maxL, maxR);
                // 宽
                int w = r - l;
                // 保留最大面积
                ans = Math.max(ans, w * h);

                // 那边是短板，就移动谁
                if (maxL < maxR) {
                    l++;
                } else {
                    r--;
                }
            }

            return ans;
        }
    }
}