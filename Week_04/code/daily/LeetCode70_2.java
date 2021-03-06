package daily;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/
 * 2020/05/04
 */
public class LeetCode70_2 {

    private Map<Integer, Integer> cache = new HashMap<>();

    @Test
    public void test1() {
        int ans = climbStairs(5);
        Assert.assertEquals(ans, 8);
    }

    @Test
    public void test2() {
        int ans = climbStairs(2);
        Assert.assertEquals(ans, 2);
    }

    /**
     * 迭代法
     * T O(n)
     * S O(1)
     */
    public int climbStairs(int n) {
        if (n < 3) return n;
        int n1 = 1, n2 = 2;
        for (int i = 2; i < n; i++) {
            int n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
        }
        return n2;
    }
}
