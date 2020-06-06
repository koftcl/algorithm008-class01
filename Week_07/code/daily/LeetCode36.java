package daily;

import org.junit.Test;

/**
 * 36. 有效的数独
 * https://leetcode-cn.com/problems/valid-sudoku/description/
 * 2020/06/05
 */
public class LeetCode36 {
    @Test
    public void test1() {

        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(isValidSudoku(board));
    }

    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowSet  = new boolean[9][9];
        boolean[][] colSet  = new boolean[9][9];
        boolean[][] gridSet  = new boolean[9][9];

        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                if (board[y][x] == '.') {
                    continue;
                }

                int curr = board[y][x] - '1';
                int g = x / 3 + y / 3 * 3;
                if (rowSet[y][curr] || colSet[x][curr] || gridSet[g][curr]) return false;
                rowSet[y][curr] = true;
                colSet[x][curr] = true;
                gridSet[g][curr] = true;
            }
        }

        return true;
    }
}
