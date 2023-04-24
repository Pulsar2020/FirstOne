package great_class28;

/**
 * Created by likz on 2023/4/21
 *
 * @author likz
 */
public class Problem_0034_FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        /*if (nums.length == 1){
            return target == nums[0] ? new int[]{0, 0} : new int[]{-1, -1};
        }
        int x = lessMostRight(nums, target);
        int y = lessMostRight(nums, target + 1);
        return y != -1 && nums[y] == target ? new int[]{x + 1, y} : new int[]{-1, -1};*/
        int L = lessMostRight(nums, target) + 1;
        if (L == nums.length || nums[L] != target) {
            return new int[] { -1, -1 };
        }
        return new int[] { L, lessMostRight(nums, target + 1) };
    }

    public int lessMostRight(int[] nums, int num) {
        int l = 0;
        int r = nums.length - 1;
        int ans = -1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] < num) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
