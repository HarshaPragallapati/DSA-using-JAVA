package Trees;

import java.util.List;
import java.util.Scanner;

import static Trees.LevelOrderTraversal.LOT;

public class SearchInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        Scanner sc = new Scanner(System.in);
        int val = sc.nextInt();
        TreeNode node =  searchBST(root, val);
        List<List<Integer>> result;
        result = LOT(node);
        System.out.println(result);
    }

    static TreeNode searchBST(TreeNode root, int val) {
        while (root != null && root.val != val){
            root = root.val > val ? root.left : root.right;
        }
        return root;
    }
}
