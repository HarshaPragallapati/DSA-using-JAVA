package Trees;

public class DiameterOfBinaryTree {
    private static int diameter = 0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        findDiameter(root);
        System.out.println(diameter);
    }

    private static int findDiameter(TreeNode root) {
        if (root == null) return 0;
        int leftH = findDiameter(root.left);
        int rightH = findDiameter(root.right);
        diameter = Math.max(diameter, leftH + rightH);
        return Math.max(leftH, rightH) + 1;
    }
}
