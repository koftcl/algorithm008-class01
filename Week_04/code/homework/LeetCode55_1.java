package homework;

import org.junit.Test;

/**
 * 跳跃游戏
 * https://leetcode-cn.com/problems/jump-game/
 * 2020/05/10
 */
public class LeetCode55_1 {
    @Test
    public void name() {

    }

    /**
     * Greedy
     * T O(n)
     * S O(1)
     */
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;

        int last = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] >= last - i) last = i;
        }

        return last == 0;
    }
}
