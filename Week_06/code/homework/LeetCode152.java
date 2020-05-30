package homework;

import org.junit.Test;

/**
 * 152. 乘积最大子数组
 * https://leetcode-cn.com/problems/maximum-product-subarray/description/
 * 2020/05/30
 */
public class LeetCode152 {
    @Test
    public void test1() {

    }

    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }
        // TODO
        return 0;
    }

}
