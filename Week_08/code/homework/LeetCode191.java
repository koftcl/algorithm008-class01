package homework;

import org.junit.Assert;
import org.junit.Test;

/**
 * 191. 位1的个数
 * https://leetcode-cn.com/problems/number-of-1-bits/
 * 2020/06/13
 */
public class LeetCode191 {
    @Test
    public void test1() {
        int ans = hammingWeight(10);
        Assert.assertEquals(ans, 2);
        System.out.println(ans);
    }

    @Test
    public void test2() {
        int ans = hammingWeight(-3);
        Assert.assertEquals(ans, 31);
        System.out.println(ans);
    }

    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) count++;
            n = n >> 1;
        }
        return count;
    }
}
