package homework;

import org.junit.Assert;
import org.junit.Test;

/**
 * 62. 不同路径
 * https://leetcode-cn.com/problems/unique-paths/
 * 2020/05/27
 */
public class LeetCode62 {
    @Test
    public void test1() {
        int ans = uniquePaths(3, 3);
        Assert.assertEquals(ans, 6);
        System.out.println(ans);
    }

    public int uniquePaths(int m, int n) {
        int[] dp = new int[m + 1];
        dp[m - 1] = 1;
        for (int j = 0; j < n; j++) {
            int [] curr = new int [m + 1];
            for (int i = m - 1; i >= 0; i--) {
                curr[i] = dp[i] + curr [i + 1];
            }
            dp = curr;
        }
        return dp[0];
    }
}
