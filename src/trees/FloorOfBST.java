package trees;

import java.util.Scanner;

public class FloorOfBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(9);
        root.left = new TreeNode(5);
        root.right = new TreeNode(17);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(7);
        Scanner sc = new Scanner(System.in);
        int key = sc.nextInt();
        int result = findFloor(root, key);
        System.out.println(result);
    }

    private static int findFloor(TreeNode root, int key) {
        int floor = -1;
        while (root != null){
            if (root.val == key){
                return root.val;
            }
            if (root.val > key){
                root = root.left;
            }
            else{
                floor = root.val;
                root = root.right;
            }
        }
        return floor;
    }
}
