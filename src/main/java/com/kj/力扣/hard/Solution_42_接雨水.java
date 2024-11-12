package com.kj.力扣.hard;

class Solution_42_接雨水 {
    public static void main(String[] args) {

    }

    static class Solution {
        public int trap(int[] height) {
            int ans = 0;
            int l = 0;
            int r = height.length - 1;
            int maxL = height[l];
            int maxR = height[r];

            while (l < r) {
                if (maxL < maxR) {
                    l++;
                    maxL = Math.max(maxL, height[l]);
                    ans += (maxL - height[l]);
                } else {
                    r--;
                    maxR = Math.max(maxR, height[r]);
                    ans += (maxR - height[r]);
                }
            }

            return ans;
        }
    }
}