package Trees;

import java.util.ArrayList;
import java.util.List;

public class RootToNodePath{
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        root.left.right.right.right = new TreeNode(7);
        int target = 7;
        List<Integer> path = new ArrayList<>();
        if (getPath(root, target, path)) {
            System.out.println("Path to " + target + ": " + path);
        } else {
            System.out.println("Target not found in tree.");
        }
    }

    private static boolean getPath(TreeNode root, int target, List<Integer> path) {
        if (root == null) return false;
        path.add(root.val);
        if (root.val == target){
            return true;
        }
        if (getPath(root.left, target, path) || getPath(root.right, target, path)){
            return true;
        }
        path.removeLast();
        return false;
    }
}
