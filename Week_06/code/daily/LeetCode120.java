package daily;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

/**
 * 120. 三角形最小路径和
 * https://leetcode-cn.com/problems/triangle/description/
 * 2020/05/27
 */
public class LeetCode120 {
    @Test
    public void test1() {

    }

    public int minimumTotal(List<List<Integer>> triangle) {
        Collections.reverse(triangle);
        int[] dp = new int[triangle.get(0).size() + 1];
        for (List<Integer> curr : triangle) {
            int i = 0;
            for (Integer integer : curr) {
                dp[i] = Math.min(dp[i], dp[i + 1]) + integer;
                i++;
            }
        }
        return dp[0];

    }
}
