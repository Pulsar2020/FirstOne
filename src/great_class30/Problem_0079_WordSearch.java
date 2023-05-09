package great_class30;


public class Problem_0079_WordSearch {
    public boolean exist(char[][] board, String word) {
        char[] str = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (process(board, str, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean process(char[][] board, char[] w, int i, int j, int index) {
        if (index == w.length) {
            return true;
        }
        // 越界判断
        if (i < 0 || i == board.length || j < 0 || j == board[0].length) {
            return false;
        }
        if (board[i][j] != w[index]) {
            return false;
        }
        char tmp = board[i][j];
        board[i][j] = 0;
        boolean res = process(board, w, i - 1, j, index + 1) || process(board, w, i + 1, j, index + 1)
                || process(board, w, i, j - 1, index + 1) || process(board, w, i, j + 1, index + 1);
        board[i][j] = tmp;
        return res;
    }

}
