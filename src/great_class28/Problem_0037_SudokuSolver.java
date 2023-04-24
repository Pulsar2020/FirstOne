package great_class28;

/**
 * Created by likz on 2023/4/23
 *
 * @author likz
 */
public class Problem_0037_SudokuSolver {
    public static void solveSudoku(char[][] board) {
        boolean[][] row = new boolean[9][10];
        boolean[][] col = new boolean[9][10];
        boolean[][] bucket = new boolean[9][10];
        initBoolSudo(board, row, col, bucket);
        process(board, 0, 0, row, col, bucket);
    }

    private static boolean process(char[][] board, int i, int j, boolean[][] row, boolean[][] col, boolean[][] bucket) {
        if (i == 9) {
            return true;
        }
        int nexti = j == 8 ? i + 1 : i;
        int nextj = j == 8 ? 0 : j + 1;
        if (board[i][j] != '.') {
            return process(board, nexti, nextj, row, col, bucket);
        } else {
            int bid = 3 * (i / 3) + j / 3;
            for (int num = 1; num <= 9; num++) {
                if ((!row[i][num]) && (!col[j][num]) && (!bucket[bid][num])) {
                    row[i][num] = true;
                    col[j][num] = true;
                    bucket[bid][num] = true;
                    board[i][j] = (char) (num + '0');
                    if (process(board, nexti, nextj, row, col, bucket)) {
                        return true;
                    }
                    row[i][num] = false;
                    col[j][num] = false;
                    bucket[bid][num] = false;
                    board[i][j] = '.';
                }
            }
        }
        return false;
    }

    private static void initBoolSudo(char[][] board, boolean[][] row, boolean[][] col, boolean[][] bucket) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int bid = 3 * (i / 3) + j / 3;
                int num = board[i][j] - '0';
                if (board[i][j] != '.') {
                    row[i][num] = true;
                    col[j][num] = true;
                    bucket[bid][num] = true;
                }
            }
        }
    }
}
