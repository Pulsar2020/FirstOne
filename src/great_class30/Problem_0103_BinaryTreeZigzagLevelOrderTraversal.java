package great_class30;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by likz on 2023/5/9
 *
 * @author likz
 */
public class Problem_0103_BinaryTreeZigzagLevelOrderTraversal {
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> dequeue = new LinkedList<>();
        dequeue.add(root);
        boolean isFromHead = true;
        while (!dequeue.isEmpty()) {
            List<Integer> e = new ArrayList<>();
            int size = dequeue.size();
            for (int i = 0; i < size; i++) {
                TreeNode t = isFromHead ? dequeue.pollLast() : dequeue.pollFirst();
                e.add(t.val);
                if (isFromHead) {
                    if (t.left != null) {
                        dequeue.addFirst(t.left);
                    }
                    if (t.right != null) {
                        dequeue.addFirst(t.right);
                    }
                } else {
                    if (t.right != null) {
                        dequeue.addLast(t.right);
                    }
                    if (t.left != null) {
                        dequeue.addLast(t.left);
                    }
                }
            }
            isFromHead = !isFromHead;
            res.add(e);
        }
        return res;
    }
}
