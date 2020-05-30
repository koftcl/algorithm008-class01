package homework;

import org.junit.Assert;
import org.junit.Test;

/**
 * 53. 最大子序和
 * https://leetcode-cn.com/problems/maximum-subarray/
 * 2020/05/30
 */
public class LeetCode53 {
    @Test
    public void test1() {
        int i = maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        Assert.assertEquals(i, 6);
        System.out.println(i);
    }

    /**
     * T O(n)
     * S O(1)
     */
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, pre = 0;

        for (int num : nums) {
            int sum = num + pre;
            max = Math.max(sum, max);
            pre = Math.max(sum, 0);
        }
        return max;
    }
}
