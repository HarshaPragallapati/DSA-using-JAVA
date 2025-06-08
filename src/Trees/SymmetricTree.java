package Trees;

public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right .right = new TreeNode(7);
        System.out.println(isSymmetric(root.left, root.right));
    }

    private static boolean isSymmetric(TreeNode root1, TreeNode root2){
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        return (root1.val == root2.val && isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left));
    }
}
