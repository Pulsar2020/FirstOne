package code;

/**
 * Created by likz on 2023/4/18
 *
 * @author likz
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        } else {
            //   -2^31 < x < 2^31 - 1  && x > 0
            String s = String.valueOf(x);
            char[] str = s.toCharArray();
            int begin = 0;
            int end = str.length - 1;
            while (begin < end){
                if(str[begin++] != str[end--]){
                    return false;
                }
            }
            return true;
        }
    }
}
