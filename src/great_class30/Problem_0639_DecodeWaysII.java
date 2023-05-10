package great_class30;

/**
 * Created by likz on 2023/5/9
 *
 * @author likz
 */
public class Problem_0639_DecodeWaysII {
    public static long mod = 1000000007;

    public static int numDecodings1(String str) {
        long[] dp = new long[str.length()];
        return (int) ways1(str.toCharArray(), 0, dp);
    }

    public static long ways1(char[] s, int i, long[] dp) {
        if (i == s.length) {
            return 1;
        }
        if (s[i] == '0') {
            return 0;
        }
        if (dp[i] != 0) {
            return dp[i];
        }
        long ans = ways1(s, i + 1, dp) * (s[i] == '*' ? 9 : 1);
        if (s[i] == '1' || s[i] == '2' || s[i] == '*') {
            if (i + 1 < s.length) {
                if (s[i + 1] == '*') {
                    ans += ways1(s, i + 2, dp) * (s[i] == '*' ? 15 : (s[i] == '1' ? 9 : 6));
                } else {
                    if (s[i] == '*') {
                        ans += ways1(s, i + 2, dp) * (s[i + 1] < '7' ? 2 : 1);
                    } else {
                        ans += ((s[i] - '0') * 10 + s[i + 1] - '0') < 27 ? ways1(s, i + 2, dp) : 0;
                    }
                }
            }
        }
        ans %= mod;
        dp[i] = ans;
        return ans;
    }
}
