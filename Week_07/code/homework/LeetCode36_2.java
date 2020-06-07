package homework;

import org.junit.Test;

/**
 * 36. 有效的数独
 * https://leetcode-cn.com/problems/valid-sudoku/description/
 * 2020/06/07
 */
public class LeetCode36_2 {
    @Test
    public void test1() {

        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(isValidSudoku(board));
    }

    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] grid = new boolean[9][9];

        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 9; i++) {
                if (board[j][i] == '.') continue;
                int g = i / 3 + j / 3 * 3;
                if (row[j][board[j][i] - '1']
                        || col[i][board[j][i] - '1']
                        || grid[g][board[j][i] - '1'])
                    return false;
                row[j][board[j][i] - '1'] = true;
                col[i][board[j][i] - '1'] = true;
                grid[g][board[j][i] - '1'] = true;
            }
        }
        return true;
    }
}
