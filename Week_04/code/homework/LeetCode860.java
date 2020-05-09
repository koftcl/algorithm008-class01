package homework;

import org.junit.Assert;
import org.junit.Test;

/**
 * 柠檬水找零
 * https://leetcode-cn.com/problems/lemonade-change/description/
 * 2020/05/09
 */
public class LeetCode860 {
    @Test
    public void test1() {
        Assert.assertTrue(lemonadeChange(new int[]{5, 5, 5, 10, 20}));
    }

    /**
     * greedy
     * T O(n)
     * S O(1)
     */
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) five += 1;
            else if (bill == 10) {
                if (five < 1) return false;
                five -= 1;
                ten += 1;
            } else {
                if (ten > 0) {
                    ten -= 1;
                    if (five == 0) return false;
                    five -= 1;
                } else {
                    if (five < 3) return false;
                    five -= 3;
                }
            }
        }
        return true;
    }
}
