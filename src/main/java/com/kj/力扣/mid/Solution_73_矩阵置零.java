package com.kj.力扣.mid;

class Solution_73_矩阵置零 {
    public static void main(String[] args) {

    }

    static class Solution {
        public void setZeroes(int[][] matrix) {
            int rows = matrix.length;
            int cols = matrix[0].length;

            // 先处理，0行0列是否需要置0
            boolean row = false;
            boolean col = false;
            for (int i = 0; i < cols; i++) {
                if (matrix[0][i] == 0) {
                    row = true;
                    break;
                }
            }
            for (int i = 0; i < rows; i++) {
                if (matrix[i][0] == 0) {
                    col = true;
                    break;
                }
            }

            // 遍历非0行0列元素
            for (int i = 1; i < rows; i++) {
                for (int j = 1; j < cols; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }

            // 非0行0列的补0
            for (int i = 1; i < rows; i++) {
                if (matrix[i][0] == 0) {
                    for (int j = 1; j < cols; j++) {
                        matrix[i][j] = 0;
                    }
                }
            }
            for (int i = 1; i < cols; i++) {
                if (matrix[0][i] == 0) {
                    for (int j = 1; j < rows; j++) {
                        matrix[j][i] = 0;
                    }
                }
            }

            // 0行0列的置0
            if (row) {
                for (int i = 0; i < cols; i++) {
                    matrix[0][i] = 0;
                }
            }
            if (col) {
                for (int i = 0; i < rows; i++) {
                    matrix[i][0] = 0;
                }
            }
        }
    }
}