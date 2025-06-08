package Trees;

public class ConstructBSTFromPreorder {
    public static void main(String[] args) {
        int[] preorder = {8,5,1,7,10,12};
        TreeNode root = bstFromPreorder(preorder);

    }

    private static TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, Integer.MAX_VALUE, new int[] {0});
    }

    private static TreeNode build(int[] preorder, int maxValue, int[] i) {
        if (i[0] == preorder.length || preorder[i[0]] > maxValue) return null;
        TreeNode root = new TreeNode(preorder[i[0]++]);
        root.left = build(preorder, root.val, i);
        root.right = build(preorder, maxValue, i);
        return root;
    }


}
