package great_class30;

/**
 * Created by likz on 2023/5/9
 *
 * @author likz
 */
public class Problem_0108_ConvertSortedArrayToBinarySearchTree {
    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0){
            return null;
        }
        return process(nums, 0, nums.length - 1);
    }

    public TreeNode process(int[] nums, int left, int right){
        // base case
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(nums[left]);
        }
        // ===
        int mid = left + ((right - left) >> 1);
        TreeNode node = new TreeNode(nums[mid]);
        node.left = process(nums, left, mid - 1);
        node.right = process(nums, mid + 1, right);
        return node;
    }
}
