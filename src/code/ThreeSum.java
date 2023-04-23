package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Created by likz on 2023/4/21
 * https://leetcode.cn/problems/3sum/
 * @author likz
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int N = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = N - 1; i > 1; i--){
            if (i == N - 1 || nums[i] != nums[i + 1]){
                List<List<Integer>> twoSum = twoSum(nums, i - 1, -nums[i]);
                for (List<Integer> e : twoSum){
                    e.add(nums[i]);
                    res.add(e);
                }
            }
        }
        return res;
    }

    public List<List<Integer>> twoSum(int[] nums, int end, int target){
        int L = 0;
        int R = end;
        List<List<Integer>> ans = new ArrayList<>();
        while(L < R){
            if (nums[L] + nums[R] < target){
                L++;
            } else if(nums[L] + nums[R] > target){
                R--;
            } else {
                if (L == 0 || nums[L - 1] != nums[L]) {
                    List<Integer> cur = new ArrayList<>();
                    cur.add(nums[L]);
                    cur.add(nums[R]);
                    ans.add(cur);
                }
                L++;
            }
        }
        return ans;
    }
}
