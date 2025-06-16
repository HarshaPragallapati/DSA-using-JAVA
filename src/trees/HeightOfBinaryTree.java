package trees;

public class HeightOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(findHeight(root));
    }

    private static int findHeight(TreeNode root) {
        if (root == null) return 0;
        int leftH = findHeight(root.left);
        int rightH = findHeight(root.right);
        return 1 + Math.max(leftH, rightH);
    }
}
