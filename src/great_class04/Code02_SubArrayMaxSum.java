package great_class04;

/**
 * Created by likz on 2023/3/23
 * // 本题测试链接 : https://leetcode.com/problems/maximum-subarray/
 * @author likz
 */
public class Code02_SubArrayMaxSum {

	public static int maxSubArray(int[] arr) {
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

	public static int maxSubArray2(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		// 上一步，dp的值
		// dp[0]
		int pre = arr[0];
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			pre = Math.max(arr[i], arr[i] + pre);
			max =  Math.max(max, pre);
		}
		return max;
	}

	public int maxProduct(int[] nums) {
		int[] dp = new int[nums.length];
		int[] min = new int[nums.length];
		dp[0] = nums[0];
		min[0] = nums[0];
		int max = dp[0];
		for (int i = 1; i < nums.length; i++){
			min[i] = Math.min(nums[i], Math.min(dp[i - 1] * nums[i], min[i - 1] * nums[i]));
			dp[i] = Math.max(nums[i], Math.max(min[i - 1] * nums[i], dp[i - 1] * nums[i]));
			max = Math.max(dp[i], max);
		}

		return max;
	}
}
