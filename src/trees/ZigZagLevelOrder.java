package trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagLevelOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right .right = new TreeNode(7);
        List<List<Integer>> result;
        result = traversal(root);
        System.out.println(result);
    }
    private static List<List<Integer>> traversal(TreeNode root){
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null){
            return res;
        }
        queue.offer(root);
        boolean right = false;
        while (!queue.isEmpty()){
            int n = queue.size();
            List<Integer> inner = new LinkedList<>();
            for (int i = 0; i < n; i++){
                TreeNode node = queue.poll();
                if (!right)
                {
                    inner.add(node.val);
                }
                else {
                    inner.addFirst(node.val);
                }
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            right = !right;
            res.add(inner);
        }
        return res;
    }
}
