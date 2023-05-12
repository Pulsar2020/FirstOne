package great_class30;

/**
 * Created by likz on 2023/5/9
 *
 * @author likz
 */
public class Problem_0124_BinaryTreeMaximumPathSum {
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

    public static class Info {
        public int maxPathSum;
        public int maxPathSumFromHead;

        public Info(int path, int head) {
            maxPathSum = path;
            maxPathSumFromHead = head;
        }
    }

    public static int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return process(root).maxPathSum;
    }

    private static Info process(TreeNode x) {
        if (x == null){
            return null;
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        int maxPathSum = x.val;
        // 不含x，  1. x左边 max，   2. x 右边 max
        if (leftInfo != null){
            maxPathSum = Math.max(maxPathSum, leftInfo.maxPathSum);
        }
        if (rightInfo != null){
            maxPathSum = Math.max(maxPathSum, rightInfo.maxPathSum);
        }
        // 含x，  1. x  2. x左边 maxFromHead + x   3. x右边 maxFromHead + x    4. 左右两边 maxFromHead + x
        int maxPathSumFromHead = x.val;
        if (leftInfo != null){
            maxPathSumFromHead = Math.max(maxPathSumFromHead, leftInfo.maxPathSumFromHead + x.val);
        }
        if (rightInfo != null){
            maxPathSumFromHead = Math.max(maxPathSumFromHead, rightInfo.maxPathSumFromHead + x.val);
        }
        if (leftInfo != null && rightInfo != null && leftInfo.maxPathSumFromHead > 0
                && rightInfo.maxPathSumFromHead > 0) {
            maxPathSum = Math.max(maxPathSum, leftInfo.maxPathSumFromHead + rightInfo.maxPathSumFromHead + x.val);
        }
        // 最大  Math.max(含x， 不含x)
        maxPathSum = Math.max(maxPathSum, maxPathSumFromHead);

        return new Info(maxPathSum, maxPathSumFromHead);
    }
}
