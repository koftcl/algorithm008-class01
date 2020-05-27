package daily;

import org.junit.Test;

import java.util.*;

/**
 * 198. 打家劫舍
 * https://leetcode-cn.com/problems/house-robber/
 * 2020/05/25
 */
public class LeetCode198 {
    @Test
    public void test1() {
        System.out.println(rob(new int[]{1, 2}));
    }
    @Test
    public void test2() {
        System.out.println(rob(new int[]{1,2,1,1}));
    }

    public int rob(int[] nums) {
        int tmp1 = 0, tmp2 = 0;
        for (int num : nums) {
            int temp = tmp1;
            tmp1 = Math.max(tmp2 + num, tmp1);
            tmp2 = temp;
        }
        return tmp1;
    }
}
