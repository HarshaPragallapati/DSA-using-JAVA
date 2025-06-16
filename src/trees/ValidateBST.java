package trees;

public class ValidateBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(12);
        boolean isValid = isValidBST(root);
        System.out.println(isValid);
    }

    private static boolean isValidBST(TreeNode root) {
        long[] result = new long[1];
        result[0] = Long.MIN_VALUE;
        return inorder(root, result);
    }

    private static boolean inorder(TreeNode root, long[] result) {
        if (root == null) return true;
        if (!inorder(root.left, result)){
            return false;
        }
        if (result[0] >= root.val){
            return false;
        }
        result[0] = root.val;
        return inorder(root.right, result);
    }
}
