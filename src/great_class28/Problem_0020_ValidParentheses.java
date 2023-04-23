package great_class28;

/**
 * Created by likz on 2023/4/21
 *
 * @author likz
 */
public class Problem_0020_ValidParentheses {
    public boolean isValid(String s) {
        if(s == null || s.length() <= 1){
            return false;
        }
        char[] str = s.toCharArray();
        char[] stack = new char[str.length];
        int index = 0;
        for (int i = 0; i < str.length; i++){
            if (str[i] == '{' || str[i] == '[' || str[i] == '('){
                stack[index++] = str[i];
            }
            if (str[i] == '}') {
                if (index - 1 < 0 || stack[index - 1] != '{'){
                    return false;
                } else {
                    stack[--index] = 0;
                }
            }
            if (str[i] == ']') {
                if (index - 1 < 0 || stack[index - 1] != '['){
                    return false;
                } else {
                    stack[--index] = 0;
                }
            }
            if (str[i] == ')') {
                if (index - 1 < 0 || stack[index - 1] != '('){
                    return false;
                } else {
                    stack[--index] = 0;
                }
            }
        }
        return index == 0;
    }
}
