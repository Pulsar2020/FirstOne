package great_class07;

/**
 * Created by likz on 2023/4/24
 * https://leetcode.cn/problems/maximum-gap/
 * @author likz
 */
public class Code03_MaxGap {
    public static int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2){
            return 0;
        }
        int len = nums.length;
        int max = nums[0];
        int min = nums[0];
        for(int i = 0; i < len; ++i){
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        if (min == max){
            return 0;
        }
        boolean[] hasNumber = new boolean[len + 1];
        int[] maxArr = new int[len + 1];
        int[] minArr = new int[len + 1];
        int bit = 0;
        for (int i = 0; i < nums.length; i++){
            bit = bucket(nums[i], len, min, max);
            maxArr[bit] = hasNumber[bit] ? Math.max(maxArr[bit], nums[i]) : nums[i];
            minArr[bit] = hasNumber[bit] ? Math.min(minArr[bit], nums[i]) : nums[i];
            hasNumber[bit] = true;
        }
        int res = 0;
        int lastMax = maxArr[0];
        int cur = 1;
        for (; cur <= len; cur++){
            if (hasNumber[cur]) {
                res = Math.max(res, minArr[cur] - lastMax);
                lastMax = maxArr[cur];
            }
        }
        return res;
    }

    public static int bucket(long num, long len, long min, long max) {
        return (int) ((num - min) * len / (max - min));
    }
}
