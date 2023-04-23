package code;

/**
 * Created by likz on 2023/4/17
 * https://leetcode.cn/problems/median-of-two-sorted-arrays/description/
 * @author likz
 */
public class MedianOfTwoSortedArr {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0){
            return 0.0;
        }
        int len = nums1.length + nums2.length;
        int[] help = new int[len];
        // merge
        int x = 0;
        int y = 0;
        int index = 0;
        while(x < nums1.length && y < nums2.length){
            help[index++] = nums1[x] <= nums2[y] ? nums1[x++] : nums2[y++];
        }
        while(x < nums1.length){
            help[index++] = nums1[x++];
        }
        while(y < nums2.length){
            help[index++] = nums2[y++];
        }
        return len % 2 == 1 ? (double) help[len / 2] : (double) (help[len / 2 - 1] + help[len / 2]) / 2;
    }

    /*
    * 示例 1：

输入：nums1 = [1,3], nums2 = [2]
输出：2.00000
解释：合并数组 = [1,2,3] ，中位数 2
示例 2：

输入：nums1 = [1,2], nums2 = [3,4]
输出：2.50000
解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5*/

}
