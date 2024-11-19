package com.kj.力扣.mid;

import java.util.Arrays;

class Solution_289_生命游戏 {
    public static void main(String[] args) {
        int[][] board = new int[4][3];
        board[0] = new int[]{0, 1, 0};
        board[1] = new int[]{0, 0, 1};
        board[2] = new int[]{1, 1, 1};
        board[3] = new int[]{0, 0, 0};

        new Solution().gameOfLife(board);

        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }

    /**
     * 位操作
     * 用  00 连个位记录不同的状态，所以不存在数据被覆盖的问题
     * 0：死  1：活
     * 00：下一次  当前
     *
     */
    static class Solution {

        private int[] stepr = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        private int[] stepc = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

        public void gameOfLife(int[][] board) {
            // 行
            int r = board.length - 1;
            // 列
            int c = board[0].length - 1;

            for (int i = 0; i <= r; i++) {
                for (int j = 0; j <= c; j++) {
                    int cur = board[i][j];
                    int alive = getLive(i, j, board);
                    if (cur == 0) {
                        // 死 -》 复活   00 -》  10
                        if (alive == 3) {
                            board[i][j] |= (1 << 1);
                        }
                    }
                    if (cur == 1) {
                        if (alive < 2 || alive > 3) {
                            // 活 -》 死   01 -》 01
                        } else {
                            // 活 -》 活   01 -》 11
                            board[i][j] |= (1 << 1);
                        }
                    }
                }
            }

            // 获取下一轮的状态，取左边的一位
            for (int i = 0; i <= r; i++) {
                for (int j = 0; j <= c; j++) {
                    board[i][j] = board[i][j] >> 1;
                }
            }
        }

        /**
         * 获取周边存活的细胞数
         */
        private int getLive(int i, int j, int[][] board) {
            int alive = 0;

            for (int s = 0; s < 8; s++) {
                int sr = i + stepr[s];
                int sc = j + stepc[s];
                if (sr < 0 || sc < 0 || sr >= board.length || sc >= board[0].length) continue;
                alive += (board[sr][sc] & 1);
            }

            return alive;
        }
    }
}