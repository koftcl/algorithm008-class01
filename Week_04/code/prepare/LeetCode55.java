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
        int tmp = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (!ans && tmp - i < nums[i] || nums.length - 1 - i <= nums[i]) {
                ans = true;
            }
            if (ans && nums[i] == 0) {
                ans = false;
                tmp = i;
            }
        }

        return ans;
    }
}
