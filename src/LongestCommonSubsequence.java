/**
 * Created by likz on 2023/2/21
 *
 * @author likz
 */
public class LongestCommonSubsequence {

    public static int longestCommonSubsequence1(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0) {
            return 0;
        }
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        return process(s1, s2, s1.length - 1, s2.length - 1);
    }

    private static int process(char[] s1, char[] s2, int i, int j) {
        if (i == 0 && j == 0) {
            return s1[i] == s2[j] ? 1 : 0;
        } else if (i == 0) {
            if (s1[i] == s2[j]) {
                return 1;
            } else {
                return process(s1, s2, i, j - 1);
            }
        } else if (j == 0) {
            if (s1[i] == s2[j]) {
                return 1;
            } else {
                return process(s1, s2, i - 1, j);
            }
        } else {
            int p1 = process(s1, s2, i - 1, j);
            int p2 = process(s1, s2, i, j - 1);
            int p3 = s1[i] == s2[j] ? (1 + process(s1, s2, i - 1, j - 1)) : 0;
            return Math.max(Math.max(p1, p2), p3);
        }
    }

    public static int longestCommonSubsequence2(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0) {
            return 0;
        }
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int[][] dp = new int[s1.length][s2.length];
        dp[0][0] = s1[0] == s2[0] ? 1 : 0;
        for (int j = 1; j < s2.length; j++) {
            dp[0][j] = s1[0] == s2[j] ? 1 : dp[0][j - 1];
        }
        for (int i = 1; i < s1.length; i++) {
            dp[i][0] = s1[i] == s2[0] ? 1 : dp[i - 1][0];
        }
        for (int i = 1; i < s1.length; i++) {
            for (int j = 1; j < s2.length; j++) {
                int p1 = dp[i - 1][j];
                int p2 = dp[i][j - 1];
                int p3 = s1[i] == s2[j] ? (1 + dp[i - 1][j - 1]) : 0;
                dp[i][j] = Math.max(Math.max(p1, p2), p3);
            }
        }
        return dp[s1.length - 1][s2.length - 1];
    }

    public static void main(String[] args) {
        String s1 = "ag1hop2i3lk456";
        String s2 = "bb1rr2rr3bb4mmm5";
        int result1 = longestCommonSubsequence1(s1, s2);
        int result2 = longestCommonSubsequence2(s1, s2);
        System.out.println(result1);
        System.out.println(result2);
    }

}
