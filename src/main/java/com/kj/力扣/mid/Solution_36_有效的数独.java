package com.kj.力扣.mid;

class Solution_36_有效的数独 {
    public static void main(String[] args) {
        char[][] board = new char[9][9];
        board[0] = new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'};
        board[1] = new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'};
        board[2] = new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'};
        board[3] = new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'};
        board[4] = new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'};
        board[5] = new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'};
        board[6] = new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'};
        board[7] = new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'};
        board[8] = new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'};

        System.out.println(new Solution().isValidSudoku(board));
    }

    static class Solution {
        public boolean isValidSudoku(char[][] board) {
            int[][] rows = new int[9][9];
            int[][] cols = new int[9][9];
            int[][][] boxs = new int[3][3][9];

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    char c = board[i][j];
                    if (c == '.') continue;

                    // 变成索引数
                    int x = Integer.parseInt(c + "") - 1;

                    // 该行是否存在
                    if (++rows[i][x] > 1) return false;
                    // 该列是否存在
                    if (++cols[x][j] > 1) return false;
                    // 该盒子是否存在
                    if (++boxs[i / 3][j / 3][x] > 1) return false;
                }
            }

            return true;
        }
    }
}