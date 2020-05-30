package homework;

import org.junit.Test;

/**
 * 1143. 最长公共子序列
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 * 2020/05/30
 */
public class LeetCode1143 {
    @Test
    public void test1() {
        int i = longestCommonSubsequence("abcde", "ace");
        System.out.println(i);
    }

//    T O(m*n)
//    S O(m*n)
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[m][n];
    }
}
