package great_class28;

/**
 * Created by likz on 2023/4/18
 *
 * @author likz
 */
public class Problem_0008_StringToInteger {
    public int myAtoi(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        String s1 = getString(s.trim());
        if (s1 == null || s1.equals("")) {
            return 0;
        }
        char[] str = s1.toCharArray();
        if (!isValid(str)) {
            return 0;
        }
        boolean flag = str[0] != '-';
        int minq = Integer.MIN_VALUE / 10;
        int minr = Integer.MIN_VALUE % 10;
        int res = 0;
        int cur = 0;
        for (int i = (str[0] == '-' || str[0] == '+')  ? 1 : 0; i < str.length; i++){
            cur = '0' - str[i];
            if ((res < minq) || (res == minq && cur < minr)) {
                return flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + cur;
        }
        if (flag && res == Integer.MIN_VALUE){
            return Integer.MAX_VALUE;
        }
        return flag ? -res : res;
    }

    public String getString(String str){
        boolean r = (str.startsWith("+") || str.startsWith("-"));
        int s = r ? 1 : 0;
        for (; s < str.length(); s++) {
            if (str.charAt(s) != '0') {
                break;
            }
        }
        // s 到了第一个不是'0'字符的位置
        int e = -1;
        // 左<-右
        for (int i = str.length() - 1; i >= (r ? 1 : 0); i--) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                e = i;
            }
        }
        // e 到了最左的 不是数字字符的位置
        return (r ? String.valueOf(str.charAt(0)) : "") + str.substring(s, e == -1 ? str.length() : e);
    }

    public static boolean isValid(char[] chas) {
        if (chas[0] != '-' && chas[0] != '+' && (chas[0] < '0' || chas[0] > '9')) {
            return false;
        }
        if ((chas[0] == '-' || chas[0] == '+') && chas.length == 1) {
            return false;
        }
        // 0 +... -... num
        for (int i = 1; i < chas.length; i++) {
            if (chas[i] < '0' || chas[i] > '9') {
                return false;
            }
        }
        return true;
    }
}
