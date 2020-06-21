package homework;

import org.junit.Assert;
import org.junit.Test;

/**
 * 63. 不同路径 II
 * https://leetcode-cn.com/problems/unique-paths-ii/
 * 2020/06/21
 */
public class LeetCode63_2 {
    @Test
    public void test1() {
        int ans = uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}});
        Assert.assertEquals(ans, 2);
        System.out.println(ans);
    }

    @Test
    public void test2() {
        int ans = uniquePathsWithObstacles(new int[][]{{0, 0}, {0, 1}});
        Assert.assertEquals(ans, 0);
        System.out.println(ans);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid[0].length;
        int n = obstacleGrid.length;
        int[] dp = new int[m + 1];
        dp[m - 1] = 1;
        for (int j = n - 1; j >= 0; j--) {
            int[] curr = new int[m + 1];
            for (int i = m - 1; i >= 0; i--) {
                if (obstacleGrid[j][i] == 1) curr[i] = 0;
                else curr[i] = dp[i] + curr[i + 1];
            }
            dp = curr;
        }
        return dp[0];
    }
}
