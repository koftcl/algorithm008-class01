package homework;

import org.junit.Test;

/**
 * 岛屿数量
 * https://leetcode-cn.com/problems/number-of-islands/
 * 2020/06/07
 */
public class LeetCode200_2 {
    @Test
    public void name() {
        char[][] grid = new char[][]{{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        System.out.println(numIslands(grid));
    }

    private int[] parent;
    private int count;
    private int n, m;

    private int find(int p) {
        while (parent[p] != p) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    private void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) return;
        parent[rootQ] = rootP;

        count--;
    }

    public int numIslands(char[][] grid) {
        n = grid.length;
        if (n == 0) return 0;
        m = grid[0].length;
        int total = n * m + 1;
        parent = new int[total];
        for (int i = 0; i < total; i++) {
            parent[i] = i;
        }

        count = total;

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (grid[j][i] == '1') {
                    if (i < m - 1 && grid[j][i + 1] == '1')
                        union(getIndex(i, j), getIndex(i + 1, j));
                    if (j < n - 1 && grid[j + 1][i] == '1')
                        union(getIndex(i, j), getIndex(i, j + 1));
                } else {
                    union(getIndex(i, j), total - 1);
                }
            }
        }

        return count - 1;
    }

    private int getIndex(int i, int j) {
        return j * m + i;
    }
}
