package great_class05;

/**
 * Created by likz on 2023/3/29
 * https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
 * @author likz
 */
public class Code01_ConstructBinarySearchTreeFromPreorderTraversal {

	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;

		public TreeNode() {
		}

		public TreeNode(int val) {
			this.val = val;
		}

		public TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public TreeNode bstFromPreorder(int[] pre) {
		if (pre == null || pre.length == 0){
			return null;
		}
		return process1(pre, 0, pre.length - 1);
	}

	public static TreeNode process1(int[] pre, int L, int R) {
		if (L > R){
			return null;
		}
		int firstBig;
		for(firstBig = L + 1; firstBig <= R && pre[firstBig] <= pre[L] ; firstBig++);

		TreeNode head = new TreeNode(pre[L]);
		head.left = process1(pre, L + 1, firstBig - 1);
		head.right = process1(pre, firstBig, R);
		return head;
	}

}
