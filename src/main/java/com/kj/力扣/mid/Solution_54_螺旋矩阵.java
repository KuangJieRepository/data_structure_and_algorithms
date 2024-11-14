package com.kj.力扣.mid;

import java.util.ArrayList;
import java.util.List;

class Solution_54_螺旋矩阵 {
    public static void main(String[] args) {

    }

    static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int t = 0;
            int b = matrix.length - 1;
            int l = 0;
            int r = matrix[0].length - 1;

            List<Integer> ans = new ArrayList<>();

            for (; ; ) {
                // left -> right
                for (int i = l; i <= r; i++) {
                    ans.add(matrix[t][i]);
                }
                if (++t > b) break;
                // top -> bottom
                for (int i = t; i <= b; i++) {
                    ans.add(matrix[i][r]);
                }
                if (l > --r) break;
                // right -> left
                for (int i = r; i >= l; i--) {
                    ans.add(matrix[b][i]);
                }
                if (t > --b) break;
                // bottom -> top
                for (int i = b; i >= t; i--) {
                    ans.add(matrix[i][l]);
                }
                if (++l > r) break;
            }

            return ans;
        }
    }
}