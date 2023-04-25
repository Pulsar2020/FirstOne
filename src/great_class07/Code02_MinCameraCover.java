package great_class07;

/**
 * Created by likz on 2023/4/24
 * https://leetcode.cn/problems/binary-tree-cameras/
 * @author likz
 */
public class Code02_MinCameraCover {
    public static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;
    }
    public int minCameraCover(TreeNode root) {
        Info data = process1(root);
        return (int) Math.min(data.uncovered + 1, Math.min(data.coveredNoCamera, data.coveredHasCamera));
    }
    // 潜台词：x是头节点，x下方的点都被覆盖的情况下
    public static class Info {
        public long uncovered; // x没有被覆盖，x为头的树至少需要几个相机
        public long coveredNoCamera; // x被相机覆盖，但是x没相机，x为头的树至少需要几个相机
        public long coveredHasCamera; // x被相机覆盖了，并且x上放了相机，x为头的树至少需要几个相机
        public Info (long un, long no, long has){
            uncovered = un;
            coveredNoCamera = no;
            coveredHasCamera = has;
        }
    }

    public static Info process1(TreeNode X) {
        if (X == null){
            return new Info(Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
        }
        Info left = process1(X.left);
        Info right = process1(X.right);
        long uncovered = left.coveredNoCamera + right.coveredNoCamera;
        long coveredNoCamera = Math.min(left.coveredHasCamera + right.coveredHasCamera
                , Math.min(left.coveredHasCamera + right.coveredNoCamera, left.coveredNoCamera + right.coveredHasCamera));
        long coveredHasCamera = Math.min(left.uncovered, Math.min(left.coveredNoCamera, left.coveredHasCamera))
                + Math.min(right.uncovered, Math.min(right.coveredNoCamera, right.coveredHasCamera)) + 1;
        return new Info(uncovered, coveredNoCamera, coveredHasCamera);
    }

    public static int minCameraCover2(TreeNode root) {
        Data data = process2(root);
        return data.cameras + (data.status == Status.UNCOVERED ? 1 : 0);
    }

    // 以x为头，x下方的节点都是被covered，x自己的状况，分三种
    public enum Status {
        UNCOVERED, COVERED_NO_CAMERA, COVERED_HAS_CAMERA
    }

    // 以x为头，x下方的节点都是被covered，得到的最优解中：
    // x是什么状态，在这种状态下，需要至少几个相机
    public static class Data {
        public Status status;
        public int cameras;

        public Data(Status status, int cameras) {
            this.status = status;
            this.cameras = cameras;
        }
    }

    public static Data process2(TreeNode X) {
        if (X == null) {
            return new Data(Status.COVERED_NO_CAMERA, 0);
        }
        Data left = process2(X.left);
        Data right = process2(X.right);
        int cameras = left.cameras + right.cameras;

        // 左、或右，哪怕有一个没覆盖
        if (left.status == Status.UNCOVERED || right.status == Status.UNCOVERED) {
            return new Data(Status.COVERED_HAS_CAMERA, cameras + 1);
        }

        // 左右孩子，不存在没被覆盖的情况
        if (left.status == Status.COVERED_HAS_CAMERA || right.status == Status.COVERED_HAS_CAMERA) {
            return new Data(Status.COVERED_NO_CAMERA, cameras);
        }
        // 左右孩子，不存在没被覆盖的情况，也都没有相机
        return new Data(Status.UNCOVERED, cameras);
    }

}
