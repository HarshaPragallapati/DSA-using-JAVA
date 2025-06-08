package Trees;

import java.util.Scanner;

public class KthSmallestInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int target = kthSmallest(root, k);
        System.out.println(target);
    }

    private static int kthSmallest(TreeNode root, int k) {
        int[] result = new int[1];
        int[] count = new int[1];
        inorder(root, k, result, count);
        return result[0];
    }

    private static void inorder(TreeNode root, int k, int[] result, int[] count) {
        if (root == null || count[0] >= k) return;
        inorder(root.left, k, result, count);
        count[0]++;
        if (count[0] == k){
            result[0] = root.val;
            return;
        }
        inorder(root.right, k, result, count);
    }
}
