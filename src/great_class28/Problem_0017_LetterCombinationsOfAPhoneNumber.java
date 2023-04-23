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
            {'a', 'b', 'c'}, // 2    0
            {'d', 'e', 'f'}, // 3    1
            {'g', 'h', 'i'}, // 4    2
            {'j', 'k', 'l'}, // 5    3
            {'m', 'n', 'o'}, // 6
            {'p', 'q', 'r', 's'}, // 7
            {'t', 'u', 'v'},   // 8
            {'w', 'x', 'y', 'z'}, // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return null;
        }
        char[] str = digits.toCharArray();
        char[] path = new char[str.length];
        process(str, 0, path, ans);
        return ans;
    }

    public static void process(char[] str, int index, char[] path, List<String> ans) {
        if (str.length == index){
            ans.add(String.valueOf(path));
        } else {
            char[] phoneStr = phone[str[index] - '2'];
            for (char e : phoneStr){
                path[index] = e;
                process(str, index + 1, path, ans);
            }
        }
    }
}
