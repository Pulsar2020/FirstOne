package great_class32;

/**
 * Create By LKUNZ on 2023/3/24
 */
public class Problem_0152_MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int[] dp = new int[nums.length];
        int[] min = new int[nums.length];
        dp[0] = nums[0];
        min[0] = nums[0];
        int ans = dp[0];
        for (int i = 1; i < nums.length; i++){
            min[i] = Math.min(nums[i], Math.min(dp[i - 1] * nums[i], min[i - 1] * nums[i]));
            dp[i] = Math.max(nums[i], Math.max(min[i - 1] * nums[i], dp[i - 1] * nums[i]));
            ans = Math.max(dp[i], ans);
        }

        return ans;
    }

    public int maxProduct2(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++){
            int curMin = Math.min(nums[i], Math.min(max * nums[i], min * nums[i]));
            int curMax = Math.max(nums[i], Math.max(min * nums[i], max * nums[i]));
            ans = Math.max(curMax, ans);
            min = curMin;
            max = curMax;
        }

        return ans;
    }
}
