package prepare;

import org.junit.Test;

import java.util.Arrays;

/**
 * 分发饼干
 * https://leetcode-cn.com/problems/assign-cookies/description/
 * 2020/05/03
 */
public class LeetCode455 {
    @Test
    public void name() {

    }

    /**
     * 遍历
     * T O(n)
     * S O(1)
     */
    public int findContentChildren(int[] g, int[] s) {
        int ans = 0;

        // 排序 O(logn)
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0, j = 0;
        // 遍历 O(n)
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                i++;
                j++;
                ans++;
            } else {
                j++;
            }
        }
        return ans;
    }
}
