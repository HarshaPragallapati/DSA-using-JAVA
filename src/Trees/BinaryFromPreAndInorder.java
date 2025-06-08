package Trees;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static Trees.LevelOrderTraversal.LOT;

public class BinaryFromPreAndInorder {
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = buildTree(preorder, inorder);
        List<List<Integer>> result;
        result = LOT(root);
        System.out.println(result);
    }

    private static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        TreeNode root = buildBinaryTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
        return root;
    }

    private static TreeNode buildBinaryTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = inMap.get(root.val);
        int leftOut = inRoot - inStart;
        root.left = buildBinaryTree(preorder, preStart + 1, preStart + leftOut,
                inorder, inStart, inRoot - 1, inMap);
        root.right = buildBinaryTree(preorder, preStart + leftOut + 1, preEnd,
                inorder, inRoot + 1, inEnd, inMap);
        return root;
    }
}
