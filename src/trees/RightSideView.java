package trees;

import java.util.ArrayList;
import java.util.List;

public class RightSideView {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right .right = new TreeNode(7);
        List<Integer> result = new ArrayList<>();
        dfs(root, 0 , result);
        System.out.println(result);
    }

    private static void dfs(TreeNode root, int i, List<Integer> result) {
        if (root == null) return;
        if (i == result.size()) result.add(root.val);
        dfs(root.right, i + 1, result);
        dfs(root.left, i + 1, result);
    }

}
