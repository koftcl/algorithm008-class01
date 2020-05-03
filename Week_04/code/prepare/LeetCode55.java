package prepare;

import org.junit.Test;

/**
 * 跳跃游戏
 * https://leetcode-cn.com/problems/jump-game/
 * 2020/05/03
 */
public class LeetCode55 {
    @Test
    public void name() {

    }

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;

        boolean ans = true;
        for (int i = nums.length - 1; i >= 0; i--) {

            if (nums[i] == 0) {
                ans = false;
            }
        }

        return ans;
    }
}
