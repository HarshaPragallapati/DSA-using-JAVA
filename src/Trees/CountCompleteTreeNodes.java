package Trees;

public class CountCompleteTreeNodes {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        int cnt = countNodes(root);
        System.out.println(cnt);
    }

    private static int countNodes(TreeNode root) {
        if (root == null) return 0;
        int left = getLeftHeight(root);
        int right = getRightHeight(root);
        if(left == right){
            return ((2 << left) - 1);
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    private static int getRightHeight(TreeNode root) {
        int count = 0;
        while(root.left != null){
            root = root.left;
            count++;
        }
        return count;
    }

    private static int getLeftHeight(TreeNode root) {
        int count = 0;
        while(root.right != null){
            root = root.right;
            count++;
        }
        return count;
    }
}
