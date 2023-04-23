package great_class28;

/**
 * Created by likz on 2023/4/20
 *
 * @author likz
 */
public class Problem_0014_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String str0 = strs[0];
        if(str0.equals("")){
            return "";
        }
        int index = str0.length();
        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            int pos = 0;
            while(pos < str.length() && pos < str0.length()  && pos <= index && str.charAt(pos) == str0.charAt(pos)){
                pos++;
            }
            if (pos == 0 ){
                return "";
            }
            index = Math.min(pos, index);
        }
        String ans = str0.substring(0, index);
        return ans;
    }
}
