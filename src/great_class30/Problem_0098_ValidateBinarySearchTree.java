package great_class30;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by likz on 2023/5/9
 *
 * @author likz
 */
public class Problem_0098_ValidateBinarySearchTree {
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

    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        int pre = 0;
        int cur = 1;
        while (cur < list.size()) {
            if (list.get(pre++) >= list.get(cur++)) {
                return false;
            }
        }
        return true;
    }

    public void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }
}
