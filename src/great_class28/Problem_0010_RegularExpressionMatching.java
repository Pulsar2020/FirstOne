package great_class28;

/**
 * Created by likz on 2023/4/19
 *
 * @author likz
 */
public class Problem_0010_RegularExpressionMatching {

    public boolean isMatch(String str, String exp) {
        if (str == null || exp == null) {
            return false;
        }
        char[] s = str.toCharArray();
        char[] e = exp.toCharArray();
        int[][] dp = new int[s.length + 1][e.length + 1];
        return isValid(s, e) && process(s, e, 0, 0, dp);
    }

    public boolean process(char[] s, char[] e, int si, int ei, int[][] dp) {
        if (dp[si][ei] != 0) {
            return dp[si][ei] == 1;
        }
        boolean res = false;
        if (ei == e.length) {
            res = si == s.length;
        } else {
            if (ei + 1 == e.length || e[ei + 1] != '*') {
                res = si != s.length && (s[si] == e[ei] || e[ei] == '.') && process(s, e, si + 1, ei + 1, dp);
            } else {
                if (si == s.length) {
                    res = process(s, e, si, ei + 2, dp);
                } else {
                    if (s[si] != e[ei] && e[ei] != '.'){
                        res = process(s, e, si, ei + 2, dp);
                    } else {
                        res = process(s, e, si, ei + 2, dp) || process(s, e, si + 1, ei, dp);
                    }
                }
            }
        }
        dp[si][ei] = res ? 1 : -1;
        return res;
    }

    public boolean isValid(char[] str, char[] exp) {
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '*' || str[i] == '.') {
                return false;
            }
        }
        for (int i = 0; i < exp.length; i++) {
            if (exp[i] == '*' && (i == 0 || exp[i - 1] == '*')) {
                return false;
            }
        }
        return true;
    }

}
