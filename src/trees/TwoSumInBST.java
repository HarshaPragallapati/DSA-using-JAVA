package trees;

import java.util.HashSet;
import java.util.Set;

public class TwoSumInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(1);
        root.right = new TreeNode(9);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.right.right = new TreeNode(10);
        System.out.println(findTarget(root, 9));
    }

    private static boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return isExists(root, k, set);
    }

    private static boolean isExists(TreeNode root, int k, Set<Integer> set) {
        if (root == null){
            return false;
        }
        if (set.contains(k - root.val)){
            return true;
        }
        set.add(root.val);
        return isExists(root.left, k, set) || isExists(root.right, k, set);
    }
}
