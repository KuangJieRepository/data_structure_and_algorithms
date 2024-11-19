package com.kj.力扣.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution_56_合并区间 {
    public static void main(String[] args) {
        int[][] intervals = {
                {1, 3},
                {8, 10},
                {2, 6},
                {15, 18}
        };

        int[][] merge = new Solution().merge(intervals);

        for (int[] m : merge) {
            System.out.println("[" + m[0] + ", " + m[1] + "]");
        }
    }

    static class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals.length == 1) return intervals;

            List<int[]> ans = new ArrayList<>();

            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

            int l = intervals[0][0];
            int r = intervals[0][1];

            for (int i = 1; i < intervals.length; i++) {
                if (r >= intervals[i][0]) {
                    r = Math.max(r, intervals[i][1]);
                } else {
                    ans.add(new int[]{l, r});

                    l = intervals[i][0];
                    r = intervals[i][1];
                }
            }

            ans.add(new int[]{l, r});

            return ans.toArray(new int[0][]);
        }
    }
}