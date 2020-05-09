package homework;

import org.junit.Assert;
import org.junit.Test;

/**
 * 买卖股票的最佳时机 II
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 * 2020/05/03
 */
public class LeetCode122_1 {
    @Test
    public void name() {
        int[] prices = new int[]{7,1,5,3,6,4};
        int ans = maxProfit(prices);
        Assert.assertEquals(ans, 7);
        System.out.println(ans);
    }

    /**
     * Greedy
     * T O(n)
     * S O(1)
     */
    public int maxProfit(int[] prices) {
        if (prices == null) return 0;
        int pre = prices[0], ans = 0;
        for (int price : prices) {
            if (price > pre) ans += price - pre;
            pre = price;
        }
        return ans;
    }
}
