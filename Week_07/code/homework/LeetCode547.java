package homework;

import org.junit.Test;

/**
 * 547. 朋友圈
 * https://leetcode-cn.com/problems/friend-circles/
 * 2020/06/07
 */
public class LeetCode547 {
    @Test
    public void test1() {
        System.out.println(findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
    }

    private int[] parent;
    private int count;
    public int findCircleNum(int[][] M) {
        int n = M.length;
        parent = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int j = 0; j < n; j++) {
            for (int i = j + 1; i < n; i++) {
                int v = M[j][i];
                if (v == 1) union(i, j);
            }
        }

        return count;

    }

    private int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    private void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        parent[rootP] = rootQ;
        count--;
    }
}
