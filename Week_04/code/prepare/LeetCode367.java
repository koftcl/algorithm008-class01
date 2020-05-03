package prepare;

import org.junit.Test;

/**
 * 有效的完全平方数
 * https://leetcode-cn.com/problems/valid-perfect-square/
 * 2020/05/03
 */
public class LeetCode367 {
    @Test
    public void name() {

    }

    /**
     * 二分查找
     * T O(nlogn)
     * S O(1)
     */
    public boolean isPerfectSquare(int num) {
        if (num < 2) return true;
        int ans, left = 2, right = num / 2;
        long tmp;
        while (left <= right) {
            ans = (right + left) / 2;
            tmp = (long)ans * ans;
            if (tmp > num) right = ans - 1;
            else if (tmp < num) left = ans + 1;
            else return true;
        }
        return false;
    }
}
