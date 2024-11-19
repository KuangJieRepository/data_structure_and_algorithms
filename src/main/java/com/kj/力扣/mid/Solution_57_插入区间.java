package com.kj.力扣.mid;

import java.util.ArrayList;
import java.util.List;

class Solution_57_插入区间 {
    public static void main(String[] args) {

    }

    static class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            List<int[]> ans = new ArrayList<>();

            for (int i = 0; i < intervals.length; i++) {
                if (newInterval[1] < intervals[i][0]) {
                    // 追加自己
                    ans.add(newInterval);
                    // 把后边的全部加进去
                    for (int j = i; j < intervals.length; j++) {
                        ans.add(intervals[j]);
                    }
                    // 已经找到位置，直接返回
                    return ans.toArray(new int[0][]);
                } else if (newInterval[0] > intervals[i][1]) {
                    ans.add(intervals[i]);
                } else {
                    // 存在相交，对范围边界进行更新
                    newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                    newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
                }
            }

            ans.add(newInterval);

            return ans.toArray(new int[0][]);
        }
    }
}