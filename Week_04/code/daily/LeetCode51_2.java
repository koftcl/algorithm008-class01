package daily;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * N皇后
 * https://leetcode-cn.com/problems/n-queens/
 * 2020/05/09
 */
public class LeetCode51_2 {
    @Test
    public void name() {
        for (List<String> solveNQueen : solveNQueens(8)) {
            System.out.println(solveNQueen);
        }
    }

    private HashSet<Integer> xSet = new HashSet<>();
    private HashSet<Integer> pieSet = new HashSet<>();
    private HashSet<Integer> naSet = new HashSet<>();

    /**
     * 回溯
     */
    public List<List<String>> solveNQueens(int n) {
        LinkedList<List<String>> ans = new LinkedList<>();
        if (n < 1) return ans;

        LinkedList<Integer> list = new LinkedList<>();
        backTrack(ans, list, n, 0);

        return ans;
    }

    private void backTrack(LinkedList<List<String>> ans, LinkedList<Integer> list, int n, int y) {
        if (y >= n) {
            ans.add(generate(list));
            return;
        }

        // 遍历
        for (int x = 0; x < n; x++) {
            if (xSet.contains(x)) continue;
            if (pieSet.contains(x - y)) continue;
            if (naSet.contains(x + y)) continue;

            xSet.add(x);
            pieSet.add(x - y);
            naSet.add(x + y);
            list.add(x);

            // drill down
            backTrack(ans, list, n, y + 1);

            // reverse states
            xSet.remove(x);
            pieSet.remove(x - y);
            naSet.remove(x + y);
            list.removeLast();
        }
    }

    private List<String> generate(LinkedList<Integer> list) {
        List<String> res = new LinkedList<>();
        for (Integer i : list) {
            StringBuilder builder = new StringBuilder();
            for (int k = 0; k < list.size(); k++) {
                if (k == i) {
                    builder.append('Q');
                } else {
                    builder.append('.');
                }
            }
            res.add(builder.toString());
        }
        return res;
    }
}
