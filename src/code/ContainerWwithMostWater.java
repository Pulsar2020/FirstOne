package code;

/**
 * Created by likz on 2023/4/19
 *
 * @author likz
 */
public class ContainerWwithMostWater {
    public int maxArea(int[] height) {
        int L = 0;
        int R = height.length - 1;
        int max = 0;
        while(L < R){
            max = Math.max(max, Math.min(height[L], height[R]) * (R - L));
            if (height[L] > height[R]) {
                R--;
            } else {
                L++;
            }
        }
        return max;
    }
}
