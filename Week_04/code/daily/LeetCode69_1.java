package daily;

import org.junit.Test;

/**
 * x 的平方根
 * https://leetcode-cn.com/problems/sqrtx/
 * 2020/05/03
 */
public class LeetCode69_1 {
    @Test
    public void name() {
        System.out.println(mySqrt(5));
    }

    /**
     * 二分查找
     * T O(nlogn)
     * S O(1)
     */
    public int mySqrt(int x) {
        if (x < 2) return x;
        long r = x;
        while (r * r > x) {
            r = (r + x / r) / 2;
        }
        return (int) r;
    }
}
