package prepare;

import org.junit.Test;

/**
 * x 的平方根
 * https://leetcode-cn.com/problems/sqrtx/
 * 2020/05/03
 */
public class LeetCode69 {
    @Test
    public void name() {
        System.out.println(mySqrt(4));
    }

    /**
     * 二分查找
     * T O(nlogn)
     * S O(1)
     */
    public int mySqrt(int x) {
        if (x < 2) return x;
        int ans, left = 2, right = x / 2;
        long tmp;
        while (left <= right) {
            ans = (right + left) / 2;
            tmp = (long)ans * ans;
            if (tmp > x) right = ans - 1;
            else if (tmp < x) left = ans + 1;
            else return ans;
        }
        return right;
    }
}
