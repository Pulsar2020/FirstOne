/**
 * Created by likz on 2022/12/9
 *
 * @author likz
 */
public class Manacher {
    /**
     * 获取最长回文子串的长度
     *
     * @param s 输入字符
     * @return 最长回文子串的长度
     */
    public static int manacher(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        char[] str = manacherString(s);
        int rightest = -1;
        int center = -1;
        int[] pArr = new int[str.length];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < str.length; i++){
            pArr[i] = rightest > i ? Math.min(pArr[2 * center - i], rightest - i) : 1;
            while(i + pArr[i] < str.length && i - pArr[i] > -1){
                if(str[i + pArr[i]] == str[i - pArr[i]]){
                    pArr[i]++;
                }else{
                    break;
                }
            }
            if(i + pArr[i] > rightest){
                center = i;
                rightest = i + pArr[i];
            }
            max = Math.max(pArr[i], max);
        }
        return max - 1;
    }

    public static int right(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = manacherString(s);
        int max = 0;
        for (int i = 0; i < str.length; i++){
            int L = i - 1;
            int R = i + 1;
            while(L >= 0 && R < str.length && str[L] == str[R]){
                L--;
                R++;
            }
            max = Math.max(max, R - L - 1);
        }
        return max / 2;
    }

    public static char[] manacherString(String s) {
        char[] str = s.toCharArray();
        char[] result = new char[2 * str.length + 1];
        int index = 0;
        for (int i = 0; i != result.length; i++) {
            result[i] = (i & 1) == 0 ? '#' : str[index++];
        }
        return result;
    }

    // for test
    public static String getRandomString(int possibilities, int size) {
        char[] ans = new char[(int) (Math.random() * size) + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (char) ((int) (Math.random() * possibilities) + 'a');
        }
        return String.valueOf(ans);
    }

    public static void main(String[] args) {
        int possibilities = 5;
        int strSize = 20;
        int testTimes = 500000;
        System.out.println("test begin");
        for (int i = 0; i < testTimes; i++) {
            String str = getRandomString(possibilities, strSize);
            if (manacher(str) != right(str)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("test finish");
    }

    // leecode 最长回文子串 https://leetcode.cn/problems/longest-palindromic-substring/
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        char[] str = manacherString(s);
        int rightest = -1;
        int center = -1;
        int[] pArr = new int[str.length];
        int max = Integer.MIN_VALUE;
        int maxPoint = 0;
        for (int i = 0; i < str.length; i++) {
            pArr[i] = rightest > i ? Math.min(pArr[2 * center - i], rightest - i) : 1;
            while (i + pArr[i] < str.length && i - pArr[i] > -1) {
                if (str[i + pArr[i]] == str[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }
            if (i + pArr[i] > rightest) {
                center = i;
                rightest = i + pArr[i];
            }
            if (pArr[i] > max) {
                max = pArr[i];
                maxPoint = center;
            }
        }
        // babad  -> #b#a#b#a#d#    cbbd -> #c#b#b#d#
        // 01234  -> 012345678910   0123 -> 012345678
//        int base = maxPoint - 1;
//        int res = max % 2 == 1 ? 1 : 0;
//        return s.substring(base / 2 - max / 2 + 1, base / 2 + max / 2 + res);
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = maxPoint - max + 1; i < maxPoint + max; i++){
            if (str[i] != '#'){
                stringBuilder.append(str[i]);
            }
        }
        return stringBuilder.toString();
    }
}
