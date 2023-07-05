package great_class28;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by likz on 2023/4/21
 *
 * @author likz
 */
public class Problem_0017_LetterCombinationsOfAPhoneNumber {
    public static char[][] phone = new char[][]{
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'},
    };

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0){
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        char[] str = digits.toCharArray();
        // 保存结果字符串
        char[] path = new char[str.length];
        // dfs
        dfs(str, 0, path, ans);
        return ans;
    }

    public static void dfs(char[] str, int index, char[] path, List<String> ans) {
        if (str.length == index){
            ans.add(String.valueOf(path));
        } else {
            char[] phoneStr = phone[str[index] - '2'];
            for (char e : phoneStr){
                path[index] = e;
                dfs(str, index + 1, path, ans);
            }
        }
    }
}
