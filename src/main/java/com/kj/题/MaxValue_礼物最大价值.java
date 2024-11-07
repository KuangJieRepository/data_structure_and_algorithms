package com.kj.题;

/**
 * 动态规划，求最大最小
 *
 * @author kj
 * @date 2024/11/5
 */
public class MaxValue_礼物最大价值 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        System.out.println(maxValue(matrix));
    }

    public static int maxValue(int[][] grid) {
        if (grid == null) return 0;

        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dp = new int[rows][cols];

        dp[0][0] = grid[0][0];

        // 处理 dp 第一行
        for (int i = 1; i < cols; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        // 处理 dp 第一列
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        // 处理其他的 dp，0行0列已被处理，都从 1 开始处理
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        // 价值权重是一路最大值加过来的，所以矩阵的右下角的数据就是最大价值和
        return dp[rows - 1][cols - 1];
    }
}
