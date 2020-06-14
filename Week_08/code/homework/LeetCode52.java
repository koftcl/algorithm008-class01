package homework;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

/**
 * 52. N皇后 II
 * https://leetcode-cn.com/problems/n-queens-ii/
 * 2020/06/13
 */
public class LeetCode52 {
    @Test
    public void test1() {
        System.out.println(totalNQueens(4));
    }

    private HashSet<Integer> col = new HashSet<>();
    private HashSet<Integer> pie = new HashSet<>();
    private HashSet<Integer> na = new HashSet<>();
    private int n, ans;

    public int totalNQueens(int n) {
        ans = 0;
        if (n < 4) return ans;
        this.n = n;

        dfs(0);

        return ans;
    }

    private void dfs(int i) {
        if (i >= n) {
            ans++;
            return;
        }

        for (int j = 0; j < n; j++) {
            if (col.contains(j) || pie.contains(j - i) || na.contains((j + i))) continue;
            col.add(j);
            pie.add(j - i);
            na.add((j + i));
            dfs(i + 1);
            col.remove(j);
            pie.remove(j - i);
            na.remove((j + i));
        }
    }
}
