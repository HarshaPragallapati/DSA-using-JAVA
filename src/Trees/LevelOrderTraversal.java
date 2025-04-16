package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    private static List<List<Integer>> LOT(Node root){
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        Queue<Node> queue = new LinkedList<Node>();
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
                inner.add(queue.poll().data);
            }
            res.add(inner);
        }
        return res;
    }
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right .right = new Node(7);
        List<List<Integer>> result;
        result = LOT(root);
        System.out.println(result);
    }
}
