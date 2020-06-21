package homework;

import org.junit.Assert;
import org.junit.Test;

/**
 * 32. 最长有效括号
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 * 2020/06/21
 */
public class LeetCode32 {
    @Test
    public void test1() {
        int i = longestValidParentheses(")()())");
        Assert.assertEquals(i, 4);
        System.out.println(i);
    }

    public int longestValidParentheses(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int[] dp = new int[n];
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}
