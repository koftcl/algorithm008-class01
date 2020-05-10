package homework;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

/**
 * 跳跃游戏 II
 * https://leetcode-cn.com/problems/jump-game-ii/
 * 2020/05/10
 */
public class LeetCode45 {
    @Test
    public void test1() {
        Assert.assertEquals(jump(new int[]{2,3,1,1,4}), 2);
    }

    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
