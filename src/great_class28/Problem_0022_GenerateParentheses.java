package great_class28;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by likz on 2023/4/21
 *
 * @author likz
 */
public class Problem_0022_GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        char[] path = new char[n << 1];
        List<String> ans = new ArrayList<>();
        process2(path,0, 0, n, ans);
        return ans;
    }

    private void process2(char[] path,int index, int leftMinusRight, int restLeft, List<String> ans) {
        if (index == path.length){
            ans.add(String.valueOf(path));
        } else {
            if (restLeft > 0){
                path[index] = '(';
                process2(path, index + 1, leftMinusRight + 1, restLeft - 1, ans);
            }
            if (leftMinusRight > 0){
                path[index] = ')';
                process2(path, index + 1, leftMinusRight - 1, restLeft, ans);
            }
        }
    }


}
