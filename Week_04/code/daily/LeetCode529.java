package daily;

import org.junit.Test;

import java.util.Arrays;

/**
 * 扫雷游戏
 * https://leetcode-cn.com/problems/minesweeper/description/
 * 2020/05/06
 */
public class LeetCode529 {
    @Test
    public void test1() {
        char[][] input = new char[][]{{'E','E','E','E','E','E','E','E'},{'E','E','E','E','E','E','E','M'},{'E','E','M','E','E','E','E','E'},{'M','E','E','E','E','E','E','E'},{'E','E','E','E','E','E','E','E'},{'E','E','E','E','E','E','E','E'},{'E','E','E','E','E','E','E','E'},{'E','E','M','M','E','E','E','E'}};
        System.out.println(Arrays.deepToString(updateBoard(input, new int[]{0, 0})));
    }

    private char[][] board;
    private int[][] mark;
    private int[][] table;

    public char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }

        this.board = board;
        this.mark = new int[board.length][board[0].length];
        this.table = new int[][]{{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};

        for (int j = 0; j < board.length; j++) {
            for (int i = 0; i < board[0].length; i++) {
                if (board[j][i] == 'M') {
                    for (int[] ints : table) {
                        if (j + ints[1] < 0 || j + ints[1] >= board.length) continue;
                        if (i + ints[0] < 0 || i + ints[0] >= board[0].length) continue;
                        mark[j + ints[1]][i + ints[0]] = mark[j + ints[1]][i + ints[0]] + 1;
                    }
                }
            }
        }

        dfs(click[1], click[0]);

        return board;
    }

    private void dfs(int col, int row) {
        if (col >= board[0].length || col < 0 || row >= board.length || row < 0 || board[row][col] != 'E') return;
        if (mark[row][col] != 0) {
            board[row][col] = (char)('0' + mark[row][col]);
            return;
        }

        board[row][col] = 'B';

        for (int[] ints : table) {
            dfs(col + ints[0], row + ints[1]);
        }
    }
}
