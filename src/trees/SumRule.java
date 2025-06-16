package trees;

import java.util.List;

import static trees.LevelOrderTraversal.LOT;

public class SumRule {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(40);
        root.left = new TreeNode(10);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(30);
        root.right.right = new TreeNode(40);
        backtrack(root);
        List<List<Integer>> result;
        result = LOT(root);
        System.out.println(result);
    }

    private static void backtrack(TreeNode root) {
        if (root == null){
            return;
        }
        int childSum = 0;
        if (root.left != null){
            childSum += root.left.val;
        }
        if (root.right != null){
            childSum += root.right.val;
        }
        if (childSum >= root.val){
            root.val = childSum;
        }
        else{
            if (root.left != null){
                root.left.val = root.val;;
            }
            if (root.right != null){
                root.right.val = root.val;;
            }
        }
        backtrack(root.left);
        backtrack(root.right);
        int sum = 0;
        if (root.left != null){
            sum += root.left.val;
        }
        if (root.right != null){
            sum += root.right.val;
        }
        if (root.left != null || root.right != null){
            root.val = sum;
        }
    }
}
