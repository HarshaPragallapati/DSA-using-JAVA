package trees;

public class MaximumProductOfSplittedBinaryTree {

    final int mod = (int) (1e9 + 7);
    private static long totalSum = 0;
    private static long res = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        System.out.println(maxProduct(root));
    }

    private static int maxProduct(TreeNode root) {
        totalSum = findTotalSum(root);
        findMaxProduct(root);
        return (int) (res);
    }

    private static long findMaxProduct(TreeNode root) {
        if (root == null) return 0;
        long currSum = root.val + findMaxProduct(root.left) + findMaxProduct(root.right);
        res = Math.max(res, currSum * (totalSum - currSum));
        return currSum;
    }

    private static int findTotalSum(TreeNode root) {
        if (root == null) return 0;
        return findTotalSum(root.left) + findTotalSum(root.right) + root.val;
    }
}
