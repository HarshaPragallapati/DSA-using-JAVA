package trees;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static trees.LevelOrderTraversal.LOT;

public class BinaryFromPostAndInorder {
    public static void main(String[] args) {
        int[] postorder = {9,15,7,20,3};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = buildTree(inorder, postorder);
        List<List<Integer>> result;
        result = LOT(root);
        System.out.println(result);
    }

    private static TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildBinaryTree(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    }

    private static TreeNode buildBinaryTree(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        if (postStart > postEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inRoot = inMap.get(root.val);
        int leftOut = inRoot - inStart;
        root.left = buildBinaryTree(postorder, postStart, postStart + leftOut - 1,
                inorder, inStart, inRoot - 1, inMap);
        root.right = buildBinaryTree(postorder, postStart + leftOut, postEnd - 1,
                inorder, inRoot + 1, inEnd, inMap);
        return root;
    }
}
