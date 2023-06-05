package great_class31;

import java.util.Stack;

/**
 * Create By LKUNZ on 2023/6/5
 */
public class Problem_0150_EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String str : tokens) {
            if ("+".equals(str) || "-".equals(str) || "*".equals(str) || "/".equals(str)){
                compulate(stack, str);
            } else {
                stack.push(Integer.valueOf(str));
            }
        }
        return stack.peek();
    }

    private void compulate(Stack<Integer> stack, String str) {
        Integer num1 = stack.pop();
        Integer num2 = stack.pop();
        Integer result = 0;
        switch (str) {
            case "+" :
                result = num2 + num1;
                break;
            case "-" :
                result = num2 - num1;
                break;
            case "*":
                result = num2 * num1;
                break;
            case "/":
                result = num2 / num1;
                break;
        }
        stack.push(result);
    }
}
