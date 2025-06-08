package Trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        System.out.println(binaryTreePaths(root));
    }

    private static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(root, sb, res);
        return res;
    }

    private static void backtrack(TreeNode root, StringBuilder sb, List<String> res) {
        if (root == null) return;
        int len = sb.length();
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            res.add(sb.toString());
        }
        else{
            sb.append("->");
            backtrack(root.left, sb, res);
            backtrack(root.right, sb, res);
        }
        sb.setLength(len);
    }
}
