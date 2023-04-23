/**
 * Created by likz on 2023/4/12
 *
 * @author likz
 */
public class IsBalanced {

    public static class Node{
        int value;
        Node left;
        Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static class Info {
        boolean isBalanced;
        int height;

        public Info(boolean i, int h) {
            isBalanced = i;
            height = h;
        }
    }

    public static boolean isBalanced2(Node head) {
        return process(head).isBalanced;
    }

    public static Info process(Node x) {
        if (x == null){
            return new Info(true, 0);
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        boolean isBalanced = true;
        if (!leftInfo.isBalanced || !rightInfo.isBalanced){
            isBalanced = false;
        }
        if (Math.abs(leftInfo.height - rightInfo.height) > 1){
            isBalanced = false;
        }
        return new Info(isBalanced, height);
    }
}
