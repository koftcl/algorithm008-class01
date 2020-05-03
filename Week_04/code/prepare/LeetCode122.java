package prepare;

import org.junit.Test;

/**
 * 买卖股票的最佳时机 II
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 * 2020/05/03
 */
public class LeetCode122 {
    @Test
    public void name() {
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    /**
     * 遍历
     * T O(n)
     * S O(1)
     */
    public int maxProfit(int[] prices) {
        int pre = prices[0], ans = 0;
        for (int price : prices) {
            if (price < pre) pre = price;
            else if (price > pre) {
                ans += price - pre;
                pre = price;
            }
        }
        return ans;
    }
}
