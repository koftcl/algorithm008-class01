package homework;

import org.junit.Assert;
import org.junit.Test;

/**
 * 152. 乘积最大子数组
 * https://leetcode-cn.com/problems/maximum-product-subarray/description/
 * 2020/05/31
 */
public class LeetCode152 {
    @Test
    public void test1() {
        int i = maxProduct(new int[]{2, 3, -2, 4});
        Assert.assertEquals(i, 6);
        System.out.println(i);
    }

    @Test
    public void test2() {
        int i = maxProduct(new int[]{-2});
        Assert.assertEquals(i, -2);
        System.out.println(i);
    }

    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] max = new int[n+1];
        int[] min = new int[n+1];
        max[0] = nums[0];
        min[0] = nums[0];
        int ans = nums[0];

        for (int i = 1; i < n; i++) {
            int num = nums[i];
            max[i] = Math.max(Math.max(max[i-1] * num, num), min[i-1] * num);
            ans = Math.max(max[i], ans);
            min[i] = Math.min(Math.min(max[i-1] * num, num), min[i-1] * num);
        }

        return ans;
    }

}
