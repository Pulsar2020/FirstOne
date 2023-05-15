package code;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int maxArea = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] <= height[stack.peek()]) {
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                int curArea = (i - k - 1) * height[j];
                maxArea = Math.max(maxArea, curArea);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            int curArea = (height.length - k - 1) * height[j];
            maxArea = Math.max(maxArea, curArea);
        }
        return maxArea;
    }

    public static int largestRectangleArea2(int[] heights) {
        if(heights == null || heights.length == 0){
            return 0;
        }
        int maxArea = Integer.MIN_VALUE;
        int[] stack = new int[heights.length];
        int index = -1;
        for (int i = 0; i < heights.length; i++){
            while(index >= 0 && heights[i] <= heights[stack[index]]){
                int j = stack[index--];
                int k = index == -1 ? -1 : stack[index];
                maxArea = Math.max(maxArea, (i - k - 1) * heights[j]);
            }
            stack[++index] = i;
        }
        while(index >= 0 ){
            int j = stack[index--];
            int k = index == -1 ? -1 : stack[index];
            maxArea = Math.max(maxArea, (heights.length - k - 1) * heights[j]);
        }
        return maxArea;
    }
}
