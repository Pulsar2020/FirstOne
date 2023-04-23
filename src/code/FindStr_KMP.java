package code;

/**
 * Created by likz on 2023/4/19
 * https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
 * @author likz
 */
public class FindStr_KMP {
    public int strStr(String haystack, String needle) {
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


    public int[] getNext(char[] str2){
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
}
