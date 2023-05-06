package code;

import java.util.LinkedList;

/**
 * Created by likz on 2023/4/26
 *
 * @author likz
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int minLength = Integer.MAX_VALUE;
        int mLeft = 0;
        int mRight = 0;
        int[] map = new int[256];
        char[] targetChar = t.toCharArray();
        for (char e : targetChar) {
            map[e]++;
        }
        int all = targetChar.length;
        char[] str = s.toCharArray();
        int L = 0;
        int R = 0;

        while (R < str.length) {
            map[str[R]]--;
            if (map[str[R]] >= 0) {
                all--;
            }
            if (all == 0) {
                while (map[str[L]] < 0) {
                    map[str[L++]]++;
                }
                if (minLength > R - L + 1) {
                    minLength = R - L + 1;
                    mLeft = L;
                    mRight = R;
                }
                all++;
                map[str[L++]]++;
            }
            R++;
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(mLeft, mRight + 1);
    }
}
