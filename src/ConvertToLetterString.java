/**
 * Created by likz on 2023/2/22
 *
 * @author likz
 */
public class ConvertToLetterString {

    // 为了测试
    public static String randomString(int len) {
        char[] str = new char[len];
        for (int i = 0; i < len; i++) {
            str[i] = (char) ((int) (Math.random() * 10) + '0');
        }
        return String.valueOf(str);
    }

    // 为了测试
    public static void main(String[] args) {
        int N = 30;
        int testTime = 1000000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int len = (int) (Math.random() * N);
            String s = randomString(len);
            int ans0 = number(s);
            int ans1 = dp1(s);
//            int ans2 = dp2(s);
            if (ans0 != ans1 /*|| ans0 != ans2*/) {
                System.out.println(s);
                System.out.println(ans0);
                System.out.println(ans1);
//                System.out.println(ans2);
                System.out.println("Oops!");
                break;
            }
        }
        System.out.println("测试结束");
    }

    private static int dp1(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        char[] str = s.toCharArray();
        int n = str.length;
        int[] dp = new int[n + 1];
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--){
            if (str[i] == '0'){
                dp[i] = 0;
            } else {
                int ways = dp[i + 1];
                if (i + 1 < str.length && (str[i] - '0') * 10 + (str[i + 1] - '0') < 27){
                    ways += dp[i + 2];
                }
                dp[i] = ways;
            }
        }
        return dp[0];
    }

    private static int number(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        return process(s.toCharArray(), 0);
    }

    private static int process(char[] str, int i) {
        if (i == str.length){
            return 1;
        }
        if (str[i] == '0'){
            return 0;
        }
        int ways = process(str, i + 1);
        if (i + 1 < str.length && (str[i] - '0') * 10 + (str[i + 1] - '0') < 27){
            ways += process(str, i + 2);
        }
        return ways;
    }
}
