package great_class28;

/**
 * Created by likz on 2023/4/23
 *
 * @author likz
 */
public class Problem_0036_ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][10];
        boolean[][] col = new boolean[9][10];
        boolean[][] bucket = new boolean[9][10];
        for(int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] != '.'){
                    int bit = 3 * (i / 3) + j / 3;
                    int num = board[i][j] - '0';
                    if (row[i][num] || col[j][num] || bucket[bit][num]){
                        return false;
                    }
                    row[i][num] = true;
                    col[j][num] = true;
                    bucket[bit][num] = true;
                }
            }
        }
        return true;
    }
}
