package great_class30;


import java.util.Arrays;

public class Problem_0091_DecodeWays {
    public int numDecodings(String s) {
        char[] str = s.toCharArray();
        return process(str, 0);
    }

    public int process(char[] str, int i) {
        if (i == str.length) {
            return 1;
        }
        if (str[i] == '0') {
            return 0;
        }
        int ways = process(str, i + 1);
        if (i + 1 == str.length) {
            return ways;
        }
        int num = (str[i] - '0') * 10 + str[i + 1] - '0';
        if (num < 27) {
            ways += process(str, i + 2);
        }
        return ways;
    }

    public int numDecodings2(String s) {
        char[] str = s.toCharArray();
        int[] dp = new int[str.length + 1];
        Arrays.fill(dp, -1);
        return process2(str, 0, dp);
    }

    private int process2(char[] str, int i, int[] dp) {
        if (dp[i] != -1) {
            return dp[i];
        }
        int ans;
        if (i == str.length) {
            ans = 1;
        } else if (str[i] == '0') {
            ans = 0;
        } else {
            int ways = process2(str, i + 1, dp);
            if (i + 1 == str.length) {
                ans = ways;
            } else {
                int num = (str[i] - '0') * 10 + str[i + 1] - '0';
                if (num < 27) {
                    ways += process2(str, i + 2, dp);
                }
                ans = ways;
            }
        }
        dp[i] = ans;
        return ans;
    }

    public static int numDecodings3(String s) {
        char[] str = s.toCharArray();
        int N = str.length;
        int[] dp = new int[N + 1];
        dp[N] = 1;
        for (int i = N - 1; i >= 0; i--) {
            if (str[i] != '0') {
                dp[i] = dp[i + 1];
                if (i + 1 == str.length) {
                    continue;
                }
                int num = (str[i] - '0') * 10 + str[i + 1] - '0';
                if (num <= 26) {
                    dp[i] += dp[i + 2];
                }
            }
        }
        return dp[0];
    }


}
