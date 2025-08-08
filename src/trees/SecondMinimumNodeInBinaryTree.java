package trees;

public class SecondMinimumNodeInBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.println(findSecondMinimumValue(root));
    }

    private static int findSecondMinimumValue(TreeNode root) {
        int min = root.val;
        long MAX = Long.MAX_VALUE;
        long[] arr = {MAX, MAX};
        findMin(root.left, 0, arr, min);
        findMin(root.right, 1, arr, min);
        if (arr[0] == MAX && arr[1] == MAX){
            return -1;
        }
        else {
            return (int) Math.min(arr[0], arr[1]);
        }
    }

    private static void findMin(TreeNode root, int index, long[] arr, int min) {
        if (root == null) return;
        if (root.val != min){
            arr[index] = Math.min(arr[index], root.val);
        }
        findMin(root.left, index, arr, min);
        findMin(root.right, index, arr, min);
    }
}
