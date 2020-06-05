package daily;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 130. 被围绕的区域
 * https://leetcode-cn.com/problems/surrounded-regions/
 * 2020/06/04
 */
public class LeetCode130 {
    @Test
    public void test1() {
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        solve(board);
        System.out.println(Arrays.deepToString(board));
    }

    char[][] board;
    int n, m;
    Set<Integer> set = new HashSet<>();
    int[] t_x = new int[]{1, -1, 0, 0};
    int[] t_y = new int[]{0, 0, 1, -1};

    public void solve(char[][] board) {
        if (board.length == 0) return;

        n = board.length;
        m = board[0].length;
        this.board = board;

        // dfs搜外围
        int x = 0, y = 0;
        for (x = 0; x < m; x++) {
            dfs(x, y);
        }
        x--;

        for (y++; y < n; y++) {
            dfs(x, y);
        }
        y--;

        for (x--; x >= 0; x--) {
            dfs(x, y);
        }
        x++;

        for (y--; y > 0; y--) {
            dfs(x, y);
        }

        // 不在set中就改
        for (y = 0; y < n; y++) {
            for (x = 0; x < m; x++) {
                int p = y * m + x;
                if (board[y][x] == 'O' && !set.contains(p)) board[y][x] = 'X';
            }
        }
    }

    private void dfs(int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n) return;
        if (board[y][x] == 'X') return;

        int p = y * m + x;
        if (set.contains(p)) return;

        set.add(p);
        for (int i = 0; i < 4; i++) {
            dfs(x + t_x[i], y + t_y[i]);
        }
    }
}
