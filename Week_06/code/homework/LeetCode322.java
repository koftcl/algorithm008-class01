package homework;

import org.junit.Test;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * https://leetcode-cn.com/problems/coin-change/
 * 2020/05/31
 */
public class LeetCode322 {
    @Test
    public void test1() {
        int i = coinChange(new int[]{1, 2, 5}, 11);
        System.out.println(i);
    }

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int n = coins.length;
        int[] dp = new int[amount+1];
        for (int i = 0; i < amount + 1; i++) {
            dp[i] = -1;
        }

        dp[0] = 0;

        for (int i = n - 1; i >= 0; i--) {
            int coin = coins[i];
            for (int j = coin; j < amount + 1; j++) {
                if (dp[j] >= 0 && dp[j - coin] >= 0) {
                    dp[j] = dp[j - coin] + 1;
                    continue;
                }
                dp[j] = Math.min(dp[j - coin] + 1, dp[j]);
            }
        }
        return dp[amount];
    }
}
