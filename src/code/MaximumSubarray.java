package code;

/**
 * Created by likz on 2023/3/23
 *
 * @author likz
 */
public class MaximumSubarray {
    public int maxSubArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[] dp = new int[arr.length];
        int max = arr[0];
        dp[0] = arr[0];
        for(int i = 1; i < arr.length; i++){
            dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
