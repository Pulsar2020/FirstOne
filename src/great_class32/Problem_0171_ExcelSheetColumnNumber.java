package great_class32;

/**
 * Create By LKUNZ on 2023/6/9
 */
public class Problem_0171_ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        char[] str = s.toCharArray();
        int ans = 0;
        for (int i = 0; i < str.length; i++){
            ans = ans * 26 + (str[i] - 'A') + 1;
        }
        return ans;
    }
}
