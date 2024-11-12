package com.kj.力扣.mid;

class Solution_274_H指数 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 1, 4};

        System.out.println(new Solution().hIndex(nums));
    }

    static class Solution {
        public int hIndex(int[] citations) {
            for (int i = citations.length - 1; i >= 0; i--) {
                int h = i + 1;
                int count = h;
                for (int citation : citations) {
                    if (citation >= h) {
                        count--;
                    }
                    if (count == 0) {
                        return h;
                    }
                }
            }

            return 1;
        }
    }
}