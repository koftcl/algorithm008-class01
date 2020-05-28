package homework;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合
 * https://leetcode-cn.com/problems/combinations/
 * 2020/05/02
 */
public class LeetCode77_3 {
    @Test
    public void name() {
        List<List<Integer>> ans = combine(4, 2);
        for (List<Integer> an : ans) {
            System.out.println(an);
        }
    }

    List<List<Integer>> ans = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        if (k > n) return ans;

        LinkedList<Integer> curr = new LinkedList<>();
        dfs(curr, 1, n, k);

        return ans;
    }

    private void dfs(LinkedList<Integer> curr, int i, int n, int k) {
        if (curr.size() == k) {
            ans.add(new LinkedList<>(curr));
            return;
        }

        for (; i <= n; i++) {
            curr.add(i);
            dfs(curr, i + 1, n, k);
            curr.pollLast();
        }
    }
}
