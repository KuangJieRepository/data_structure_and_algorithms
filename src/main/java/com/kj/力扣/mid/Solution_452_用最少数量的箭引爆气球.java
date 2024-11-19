package com.kj.力扣.mid;

import java.util.Arrays;
import java.util.Comparator;

class Solution_452_用最少数量的箭引爆气球 {
    public static void main(String[] args) {
// points = [[10,16],[2,8],[1,6],[7,12]]
        int[][] points = new int[][]{
                {-2147483646, -2147483645},
                {2147483646, 2147483647}
        };

        System.out.println(new Solution().findMinArrowShots(points));
    }

    static class Solution {
        public int findMinArrowShots(int[][] points) {
            if (points.length == 0) return 0;

            Arrays.sort(points, Comparator.comparing(a -> a[1]));

            int ans = 0;

            int right = points[0][1];

            for (int i = 1; i < points.length; i++) {
                if (right <= points[i][0]) {
                    continue;
                }
                right = points[i][1];
                ans++;
            }

            return ans + 1;
        }
    }
}