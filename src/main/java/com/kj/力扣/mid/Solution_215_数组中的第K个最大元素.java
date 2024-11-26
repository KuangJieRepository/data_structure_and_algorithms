package com.kj.力扣.mid;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution_215_数组中的第K个最大元素 {
    public static void main(String[] args) {

    }

    static class Solution {

        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, Comparator.comparingInt(a -> a));

            for (int i = 0; i < k; i++) {
                minHeap.offer(nums[i]);
            }

            for (int j = k; j < nums.length; j++) {
                Integer top = minHeap.peek();
                if (nums[j] > top) {
                    minHeap.poll();
                    minHeap.offer(nums[j]);
                }
            }

            return minHeap.peek();
        }
    }
}