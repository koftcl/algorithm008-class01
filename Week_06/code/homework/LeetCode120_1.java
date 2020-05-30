package homework;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

/**
 * 120. 三角形最小路径和
 * https://leetcode-cn.com/problems/triangle/description/
 * 2020/05/30
 */
public class LeetCode120_1 {
    @Test
    public void test1() {

    }

    /**
     * T O(n)
     * S O(k)
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null) return 0;
        Collections.reverse(triangle);
        int n = triangle.get(0).size();
        int[] dp = new int[n + 1];
        for (List<Integer> line : triangle) {
            for (int i = 0; i < line.size(); i++) {
                dp[i] = Math.min(dp[i], dp[i+1]) + line.get(i);
            }
        }
        return dp[0];
    }
}
