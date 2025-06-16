package trees;

import java.util.List;
import java.util.Scanner;

import static trees.LevelOrderTraversal.LOT;

public class DeleteNodeInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        Scanner sc = new Scanner(System.in);
        int key = sc.nextInt();
        TreeNode newRoot = deleteNode(root, key);
        List<List<Integer>> result;
        result = LOT(newRoot);
        System.out.println(result);
    }

    private static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key){
            return helper(root);
        }
        TreeNode temp = root;
        while (root != null){
            if (root.val > key){
                if (root.left != null && root.left.val == key){
                    root.left = helper(root.left);
                    break;
                }
                else{
                    root = root.left;
                }
            }
            else{
                if (root.right != null && root.right.val == key){
                    root.right = helper(root.right);
                    break;
                }
                else{
                    root = root.right;
                }
            }
        }
        return temp;
    }

    private static TreeNode helper(TreeNode root) {
        if (root.left == null){
            return root.right;
        }
        else if (root.right == null) {
            return root.left;
        }
        TreeNode rightChild = root.right;
        TreeNode lastRight = findLastRight(root.left);
        lastRight.right = rightChild;
        return root.left;
    }

    private static TreeNode findLastRight(TreeNode root) {
        if (root.right == null){
            return root;
        }
        return findLastRight(root.right);
    }
}
