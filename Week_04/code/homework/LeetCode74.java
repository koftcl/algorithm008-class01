package homework;

import org.junit.Test;

/**
 * 搜索二维矩阵
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 * 2020/05/10
 */
public class LeetCode74 {
    @Test
    public void test1() {

    }

    private int xLen;
    private int[][] matrix;

    /**
     * binary search
     * T O(logn)
     * S O(1)
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        this.xLen = matrix[0].length;
        int yLen = matrix.length;
        this.matrix = matrix;
        int lo = 0, hi = xLen * yLen - 1;
        while (hi >= lo) {
            int mid = (hi + lo) >> 1;
            if (getInt(mid) == target) return true;
            if (getInt(mid) > target)
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return false;
    }

    private int getInt(int i) {
        int x = i % xLen;
        int y = i / xLen;
        return this.matrix[y][x];
    }
}
