package com.kj.力扣.mid;

class Solution_134_加油站 {
    public static void main(String[] args) {

    }

    static class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int total = 0;
            int sum = 0;
            int start = 0;

            for (int i = 0; i < gas.length; i++) {
                total += gas[i] - cost[i];
                sum += gas[i] - cost[i];
                if (sum < 0) {
                    start = i + 1;
                    sum = 0;
                }
            }

            if (total < 0) return -1;

            return start;
        }
    }
}