package code;

import java.util.Stack;

/**
 * Create By LKUNZ on 2023/6/7
 */
public class MinStack {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MinStack() {
        stackData = new Stack<Integer>();
        stackMin = new Stack<Integer>();
    }

    public void push(int newNum) {
        if (stackMin.isEmpty() || newNum <= this.getMin()) {
            stackMin.push(newNum);
        }
        stackData.push(newNum);
    }

    public void pop() {
        if (stackData.isEmpty()) {
            throw new RuntimeException("Your stack is empty.");
        }
        int value = stackData.pop();
        if (value == getMin()) {
            stackMin.pop();
        }
    }

    public int top() {
        return stackData.peek();
    }

    public int getMin() {
        if (stackMin.isEmpty()) {
            throw new RuntimeException("Your stack is empty.");
        }
        return stackMin.peek();
    }
}
