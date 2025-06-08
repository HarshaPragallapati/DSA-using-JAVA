package Trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    static List<List<Integer>> LOT(TreeNode root){
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root == null){
            return res;
        }
        queue.offer(root);
        while (!queue.isEmpty()){
            int n = queue.size();
            List<Integer> inner = new LinkedList<>();
            for (int i = 0; i < n; i++){
                if (queue.peek().left != null){
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null){
                    queue.offer(queue.peek().right);
                }
                inner.add(queue.poll().val);
            }
            res.add(inner);
        }
        return res;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right .right = new TreeNode(7);
        List<List<Integer>> result;
        result = LOT(root);
        System.out.println(result);
    }
}
