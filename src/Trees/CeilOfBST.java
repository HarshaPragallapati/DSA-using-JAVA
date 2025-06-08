package Trees;

import java.util.Scanner;

public class CeilOfBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        Scanner sc = new Scanner(System.in);
        int key = sc.nextInt();
        int result = findCeil(root, key);
        System.out.println(result);
    }

    private static int findCeil(TreeNode root, int key) {
        int ceil = -1;
        while (root != null){
            if (root.val == key){
                return root.val;
            }
            if (root.val < key){
                root = root.right;
            }
            else{
                ceil = root.val;
                root = root.left;
            }
        }
        return ceil;
    }
}
