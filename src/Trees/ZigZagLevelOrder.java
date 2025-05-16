package Trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagLevelOrder {
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right .right = new Node(7);
        List<List<Integer>> result;
        result = traversal(root);
        System.out.println(result);
    }
    private static List<List<Integer>> traversal(Node root){
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        Queue<Node> queue = new LinkedList<>();
        if (root == null){
            return res;
        }
        queue.offer(root);
        boolean right = false;
        while (!queue.isEmpty()){
            int n = queue.size();
            List<Integer> inner = new LinkedList<>();
            for (int i = 0; i < n; i++){
                Node node = queue.poll();
                if (!right)
                {
                    inner.add(node.data);
                }
                else {
                    inner.addFirst(node.data);
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
