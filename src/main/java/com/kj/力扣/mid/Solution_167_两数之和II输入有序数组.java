package com.kj.力扣.mid;

class Solution_167_两数之和II输入有序数组 {
    public static void main(String[] args) {

    }

    static class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int i = 0;
            int j = numbers.length - 1;
            while (i < j) {
                int sum = numbers[i] + numbers[j];
                if (sum > target) {
                    j--;
                } else if (sum < target) {
                    i++;
                } else {
                    return new int[]{i + 1, j + 1};
                }
            }

            return null;
        }
    }
}