package trees;

import java.util.Scanner;

public class InsertNodeIntoBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        Scanner sc = new Scanner(System.in);
        int val = sc.nextInt();
        TreeNode node = insertIntoBST(root, val);
    }

    private static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null){
            return new TreeNode(val);
        }
        TreeNode curr = root;
        while (true){
            if (curr.val <= val){
                if (curr.right != null){
                    curr = curr.right;
                }
                else{
                    curr.right = new TreeNode(val);
                    break;
                }
            }
            else{
                if (curr.left != null){
                    curr = curr.left;
                }
                else{
                    curr.left = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }
}
