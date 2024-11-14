package com.kj.力扣.mid;

class Solution_48_旋转图像 {
    public static void main(String[] args) {

    }

    static class Solution {
        public void rotate(int[][] matrix) {
            int l = 0;
            int r = matrix[0].length - 1;
            while (l < r) {
                for (int i = 0; i < r - l; i++) {
                    int t = l;
                    int b = r;

                    int tmp = matrix[t][l + i];
                    matrix[t][l + i] = matrix[b - i][l];
                    matrix[b - i][l] = matrix[b][r - i];
                    matrix[b][r - i] = matrix[t + i][r];
                    matrix[t + i][r] = tmp;
                }
                l++;
                r--;
            }
        }
    }
}