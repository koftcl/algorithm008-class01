package daily;

import org.junit.Test;

import java.util.Arrays;

/**
 * 221. 最大正方形
 * https://leetcode-cn.com/problems/maximal-square/
 * 2020/05/30
 */
public class LeetCode221 {
    @Test
    public void dealStr() {
        String s = "[[\"1\",\"0\",\"1\",\"0\",\"0\"],[\"1\",\"0\",\"1\",\"1\",\"1\"],[\"1\",\"1\",\"1\",\"1\",\"1\"],[\"1\",\"0\",\"0\",\"1\",\"0\"]]";
        s = s.replace("[", "{");
        s = s.replace("]", "}");
        s = s.replace("\"", "'");
        System.out.println(s);
    }

    @Test
    public void test1() {
        System.out.println(maximalSquare(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}));
    }

    public int maximalSquare(char[][] matrix) {
        int m = matrix[0].length;
        int n = matrix.length;

        int[][] dp = new int[n+1][m+1];
        int max = 0;

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (matrix[j][i] == '1') {
                    int curr = Math.min(Math.min(dp[j+1][i], dp[j][i+1]), dp[j][i]) + 1;
                    dp[j+1][i+1] = curr;
                    max = Math.max(curr, max);
                }
            }
        }
        return max * max;
    }

    private void print(String s, int[][] matrix) {
        System.out.println(s + ": ");
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
