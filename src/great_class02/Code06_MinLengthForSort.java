package great_class02;

/**
 * Created by likz on 2023/3/22
 * // 本题测试链接 : https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
 * @author likz
 */
public class Code06_MinLengthForSort {

    public static int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int N = nums.length;
        int max = nums[0];
        int right = -1;
        for (int i = 0; i < N; i++){
            if (max > nums[i]){
                right = i;
            } else {
                max = nums[i];
            }
        }

        int min = nums[N - 1];
        int left = N;
        for (int i = N - 1; i >= 0; i--){
            if (min < nums[i]){
                left = i;
            } else {
                min = nums[i];
            }
        }
        return Math.max(0, right - left + 1);
    }

}
