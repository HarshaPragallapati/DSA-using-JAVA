package trees;

public class PathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(1);
        root.right = new TreeNode(9);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.right.right = new TreeNode(10);
        int targetSum = 27;
        System.out.println(hasPathSum(root, targetSum));
    }

    private static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return hasPathSum(root.left, targetSum - root.val) ||
                hasPathSum(root.right, targetSum - root.val);
    }
}
