package great_class29;

/**
 * Created by likz on 2023/4/25
 *
 * @author likz
 */
public class Problem_0073_SetMatrixZeroes {
    public static void setZeroes(int[][] matrix) {
        boolean rowZeroFlag = false;
        boolean colZeroFlag = false;
        int i;
        int j;
        for (j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                rowZeroFlag = true;
                break;
            }
        }
        for (i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                colZeroFlag = true;
                break;
            }
        }
        for (i = 1; i < matrix.length; i++) {
            for (j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (i = 1; i < matrix.length; i++) {
            for (j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (rowZeroFlag) {
            for (j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }

        if (colZeroFlag) {
            for (i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
