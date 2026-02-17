package trees;

public class LongestUnivaluePath {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right .right = new TreeNode(5);
        System.out.println(longestUnivaluePath(root));
    }

    private static int longestUnivaluePath(TreeNode root) {
        int[] res = {0};
        dfs(root, res);
        return res[0];
    }

    public static int dfs(TreeNode root, int[] res){
        if(root == null) return 0;
        int left = dfs(root.left, res);
        int right = dfs(root.right, res);
        int leftPath = 0;
        int rightPath = 0;
        if(root.left != null && root.val == root.left.val){
            leftPath += left + 1;
        }
        if(root.right != null && root.val == root.right.val){
            rightPath += right + 1;
        }
        res[0] = Math.max(res[0], leftPath + rightPath);
        return Math.max(leftPath, rightPath);
    }
}
