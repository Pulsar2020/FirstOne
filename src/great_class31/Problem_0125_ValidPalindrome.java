package great_class31;

/**
 * Created by likz on 2023/5/22
 *
 * @author likz
 */
public class Problem_0125_ValidPalindrome {
    /**
     * 忽略空格、忽略大小写 -> 是不是回文
     *
     * @param s 输入待判断的字符串
     * @return 是不是回文 true or false
     */
    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        char[] str = s.toCharArray();
        int L = 0;
        int R = str.length - 1;
        while (L < R) {
            if (isValid(str[L]) && isValid(str[R])){
                if (isEqual(str[L], str[R])){
                    L++;
                    R--;
                } else {
                    return false;
                }
            } else {
                L += isValid(str[L]) ? 0 : 1;
                R -= isValid(str[R]) ? 0 : 1;
            }
        }
        return true;
    }

    public static boolean isEqual(char ch1, char ch2) {
        if (isNumber(ch1) && isNumber(ch2)){
            return ch1 == ch2;
        }
        if (isLetter(ch1) && isLetter(ch2)){
            return ch1 == ch2 || Math.abs(ch1 - ch2) == 32;
        }
        return false;
    }

    public static boolean isValid(char ch) {
        return isNumber(ch) || isLetter(ch);
    }

    public static boolean isNumber(char ch) {
        return ch >= '0' && ch <= '9';
    }

    public static boolean isLetter(char ch) {
        return ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z';
    }
}
