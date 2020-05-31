package homework;

import org.junit.Test;

/**
 * 64. 最小路径和
 * https://leetcode-cn.com/problems/minimum-path-sum/
 * 2020/05/31
 */
public class LeetCode64 {
    @Test
    public void test1() {
        int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        int i = minPathSum(grid);
        System.out.println(i);
    }

    /*
    T O(mn)
    S O(mn)
     */
    public int minPathSum(int[][] grid) {
        int m = grid[0].length;
        int n = grid.length;
        int[][] dp = new int[n][m];

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (j == 0 && i == 0) {
                    dp[j][i] = grid[j][i];
                } else if (j == 0) {
                    dp[j][i] = dp[j][i-1] + grid[j][i];
                } else if (i == 0) {
                    dp[j][i] = dp[j-1][i] + grid[j][i];
                } else {
                    dp[j][i] = Math.min(dp[j-1][i], dp[j][i-1]) + grid[j][i];
                }
            }
        }
        return dp[n-1][m-1];
    }
}
