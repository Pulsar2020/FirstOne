package code;

/**
 * Created by likz on 2023/4/19
 *
 * @author likz
 */
public class zigzagConversion {
    public static String convert(String s, int numRows) {
        if (numRows == 1){
            return s;
        }
        char[][] res = new char[numRows][s.length() / 2 + 1];
        char[] str = s.toCharArray();
        boolean downOrLeftUp = true;
        int row = 0;
        int col = 0;
        for (char c : str) {
            // 往下
            if (downOrLeftUp) {
                res[row][col] = c;
                // 边界，改变方向
                if (row == numRows - 1) {
                    downOrLeftUp = false;
                    row--;
                    col++;
                } else {
                    row++;
                }
            }
            // 往右上
            else {
                res[row][col] = c;
                if (row == 0) {
                    downOrLeftUp = true;
                    row++;
                } else {
                    row--;
                    col++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char[] re : res) {
            for (int j = 0; j < res[0].length; j++) {
                if (re[j] != 0) {
                    sb.append(re[j]);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        char[] ch = new char[10];
        System.out.println(ch[0] == 0);
        System.out.println("PAYPALISHIRING".length());
        convert("AB", 1);
    }
}
