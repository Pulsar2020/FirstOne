package code;

/**
 * Created by likz on 2023/4/23
 *
 * @author likz
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length == 0){
            return 0;
        }
        int len = height.length;
        // leftMax
        int[] leftMax = new int[len + 1];
        int max = height[0];
        leftMax[1] = height[0];
        for (int i = 1; i < len; i++){
            max = Math.max(max, height[i]);
            leftMax[i + 1] = max;
        }
        // rightMax
        int[] rightMax = new int[len + 1];
        max = height[len - 1];
        for (int j = len - 1; j >= 1; j--){
            max = Math.max(max, height[j]);
            rightMax[j - 1] = max;
        }
        int sum = 0;
        for (int index = 0; index < len; index ++){
            int boundary = Math.min(rightMax[index], leftMax[index]);
            sum += boundary > height[index] ? boundary - height[index] : 0;
        }
        return sum;
    }
}
