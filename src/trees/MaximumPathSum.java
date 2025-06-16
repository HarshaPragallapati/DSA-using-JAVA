package trees;

public class MaximumPathSum {
    private static int max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        findMaxPath(root);
        System.out.println(max);
    }

    private static int findMaxPath(TreeNode root) {
        if (root == null) return 0;
        int leftH = Math.max(0, findMaxPath(root.left));
        int rightH = Math.max(0,findMaxPath(root.right));
        max = Math.max(max, leftH + rightH + root.val);
        return root.val + Math.max(leftH, rightH);
    }
}
