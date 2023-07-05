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
        char[] str0 = strs[0].toCharArray();
        if(str0.equals("")){
            return "";
        }
        int index = str0.length;
        for (int i = 1; i < strs.length; i++) {
            char[] str = strs[i].toCharArray();
            int pos = 0;
            while(pos < str.length && pos < str0.length  && pos <= index && str[pos] == str0[pos]){
                pos++;
            }
            if (pos == 0 ){
                return "";
            }
            index = Math.min(pos, index);
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < index; i++) {
            res.append(str0[i]);
        }
        return res.toString();
    }
}
