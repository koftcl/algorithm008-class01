package homework;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 130. 被围绕的区域
 * https://leetcode-cn.com/problems/surrounded-regions/
 * 2020/06/07
 */
public class LeetCode130_2 {
    @Test
    public void test1() {
        char[][] board = {{'X','O','O','X','X','X','O','X','O','O'},{'X','O','X','X','X','X','X','X','X','X'},{'X','X','X','X','O','X','X','X','X','X'},{'X','O','X','X','X','O','X','X','X','O'},{'O','X','X','X','O','X','O','X','O','X'},{'X','X','O','X','X','O','O','X','X','X'},{'O','X','X','O','O','X','O','X','X','O'},{'O','X','X','X','X','X','O','X','X','X'},{'X','O','O','X','X','O','X','X','O','O'},{'X','X','X','O','O','X','O','X','X','O'}};
        solve(board);
        for (char[] chars : board) {
            System.out.println(chars);
        }
    }

    public class UnionFind {
        private int[] parent;
        private int count;
        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            parent[rootQ] = rootP;
            count--;
        }

        public boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }
    }

    private int n, m;

    public void solve(char[][] board) {
        n = board.length;
        if (n == 0) return;
        m = board[0].length;
        int total = n * m;
        UnionFind uf = new UnionFind(total + 1);

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (board[j][i] != 'O') continue;
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    uf.union(getIndex(i, j), total);
                }

                if (i < m - 1 && board[j][i + 1] == 'O') uf.union(getIndex(i, j), getIndex(i + 1, j));
                if (j < n - 1 && board[j + 1][i] == 'O') uf.union(getIndex(i, j), getIndex(i, j + 1));
            }
        }

        for (int j = 1; j < n - 1; j++) {
            for (int i = 1; i < m - 1; i++) {
                if (board[j][i] == 'O' && !uf.isConnected(total, getIndex(i, j)))
                    board[j][i] = 'X';
            }
        }
    }

    private int getIndex(int i, int j) {
        return j * m + i;
    }
}
