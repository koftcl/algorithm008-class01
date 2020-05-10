package homework;

import org.junit.Test;

import java.util.*;

/**
 * 模拟行走机器人
 * https://leetcode-cn.com/problems/walking-robot-simulation
 * 2020/05/09
 */
public class LeetCode874 {

    @Test
    public void test1() {
    }

    /**
     * Greedy
     * T O(n*k)
     * S O(1)
     */
    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] mode = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int index = 0, ans = 0;
        int x = 0, y = 0;
        for (int command : commands) {
            if (command == -1) index = (index + 1) % 4;
            else if (command == -2) index = (index + 3) % 4;
            else {
                for (int i = 0; i < command; i++) {
                    x += mode[index][0];
                    y += mode[index][1];
                    if (isObstacles(x, y, obstacles)) {
                        x -= mode[index][0];
                        y -= mode[index][1];
                        ans = Math.max(ans, x * x + y * y);
                    }
                }
            }
        }
        return ans;
    }

    private boolean isObstacles(int x, int y, int[][] obstacles) {
        for (int[] obstacle : obstacles) {
            if (x == obstacle[0] && y == obstacle[1]) return true;
        }
        return false;
    }
}
