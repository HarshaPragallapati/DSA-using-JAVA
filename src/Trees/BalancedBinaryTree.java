package Trees;

public class BalancedBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        root.left.right.right.right = new TreeNode(7);

        System.out.println(isBalanced(root) ? true : false);
    }

    private static boolean isBalanced(TreeNode root) {
        return calculateHeight(root) != -1;
    }

    private static int calculateHeight(TreeNode root) {
        if (root == null) return 0;
        int leftH = calculateHeight(root.left);
        if (leftH == -1){
            return -1;
        }
        int rightH = calculateHeight(root.right);
        if (rightH == -1){
            return -1;
        }

        if (Math.abs(leftH - rightH) > 1){
            return -1;
        }

        return Math.max(leftH, rightH) + 1;
    }
}
