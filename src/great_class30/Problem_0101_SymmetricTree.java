package great_class30;

/**
 * Created by likz on 2023/5/9
 *
 * @author likz
 */
public class Problem_0101_SymmetricTree {
    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        return symmetric(root, root);
    }

    public boolean symmetric(TreeNode node1, TreeNode node2) {
        if (node1 == null ^ node2 == null) {
            return false;
        }
        if (node1 == null && node2 == null) {
            return true;
        }
        return node1.val == node2.val && symmetric(node1.left, node2.right) && symmetric(node1.right, node2.left);
    }
}
