package great_class29;

/**
 * Created by likz on 2023/4/25
 * 这个版本可以通过Leetcode 33、Leetcode 81两个题目
 * // Leetcode 33 : https://leetcode.cn/problems/search-in-rotated-sorted-array
 * // Leetcode 81 : https://leetcode.cn/problems/search-in-rotated-sorted-array-ii
 * // 注意在提交leetcode 81题时，请把code中返回下标的地方，改成返回boolean类型的返回值
 *
 * @author likz
 */
public class Problem_0033_SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while(left <= right){
            mid = left + ((right - left) >> 1);
            if (nums[mid] == target){
                return mid;
            }
            // nums[left] == nums[right] == nums[mid]
            if (nums[left] == nums[right] && nums[right] == nums[mid]){
                while(left != mid && nums[left] == nums[mid]){
                    left++;
                }
                // left走到mid，下标 left...mid 所有值相等
                if (left == mid){
                    left = mid + 1;
                    continue;
                }
            }
            if (nums[left] != nums[mid]){
                // nums[left] < nums[mid]，left ... mid 有序
                if (nums[left] < nums[mid]) {
                    if (target >= nums[left] && target < nums[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else {
                    // 断点在 left ... mid
                    if (target > nums[mid] && target <= nums[right]){
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            } else {
                // nums[left] == nums[mid] -> nums[mid] != nums[right]
                if (nums[mid] < nums[right]) {
                    // mid... right 有序
                    if (target > nums[mid] && target <= nums[right]){
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                } else {
                    // 断点在 mid ... right
                    if (target >= nums[left] && target < nums[mid]){
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }
        }
        return -1;
    }
}
