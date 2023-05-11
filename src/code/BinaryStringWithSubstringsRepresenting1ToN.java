package code;

/**
 * Created by likz on 2023/5/11
 * https://leetcode.cn/problems/binary-string-with-substrings-representing-1-to-n/
 * @author likz
 */
public class BinaryStringWithSubstringsRepresenting1ToN {
    public static boolean queryString(String s, int n) {
        for (int i = n; i >= 1; i--){
            if (KMP(s, String.valueOf(toBinaryStr(i))) == -1){
                return false;
            }
        }
        return true;
    }

    public static int KMP(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length() || needle.length() < 1){
            return -1;
        }
        char[] str1 = haystack.toCharArray();
        char[] str2 = needle.toCharArray();
        int[] next = getNext(str2);
        int x = 0;
        int y = 0;
        while(x < str1.length && y < str2.length){
            if (str1[x] == str2[y]){
                x++;
                y++;
            } else if (next[y] == -1){
                x++;
            } else {
                y = next[y];
            }
        }
        return y == str2.length ? x - y : -1;
    }


    public static int[] getNext(char[] str2){
        if (str2.length == 1){
            return new int[]{-1};
        }
        int[] next = new int[str2.length];
        next[0] = -1;
        next[1] = 0;
        int index = 2;
        int cn = 0;
        while(index < str2.length){
            if (str2[index - 1] == str2[cn]){
                next[index++] = ++cn;
            } else if(cn != 0){
                cn = next[cn];
            } else {
                index++;
            }
        }
        return next;
    }

    public static char[] toBinaryStr(int n){
        int index = 0;
        for (int i = 30; i >= 0; i--){
            if (((n >> i) & 1) == 1){
                index = i;
                break;
            }
        }
        char[] str = new char[index + 1];
        int j = 0;
        for (int i = index; i >= 0; i--){
            str[j++] = ((n >> i) & 1) == 1 ? '1' : '0';
        }
        return str;
    }



    public static void main(String[] args) {
        System.out.println(queryString("0110", 3));
        System.out.println(queryString("1", 1));
    }
}
