package code;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Create By LKUNZ on 2023/6/11
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        int index = 0;
        boolean zeroflag = true;
        for (int num : nums) {
            strs[index++] = num + "";
            if (zeroflag && num != 0) {
                zeroflag = false;
            }
        }
        if (zeroflag) {
            return "0";
        }
        Arrays.sort(strs, new MyComparator());
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < strs.length; i++){
            ans.append(strs[i]);
        }

        return ans.toString();
    }

    public static class MyComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            return (b + a).compareTo(a + b);
        }
    }
}
