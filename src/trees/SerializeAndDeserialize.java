package trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static trees.LevelOrderTraversal.LOT;

public class SerializeAndDeserialize {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String data = serialize(root);
        System.out.println(data);
        TreeNode newRoot = deserialize(data);
        List<List<Integer>> result;
        result = LOT(newRoot);
        System.out.println(result);
    }

    private static String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.add(root);
        while (!q.isEmpty()){
            TreeNode node = q.poll();
            if (node == null){
                sb.append("# ");
                continue;
            }
            sb.append(node.val).append(" ");
            q.add(node.left);
            q.add(node.right);
        }
        return sb.toString();
    }

    private static TreeNode deserialize(String data) {
        if (data == null) return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] nodes = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        q.add(root);
        for (int i = 1; i < nodes.length; i++) {
            TreeNode parent = q.poll();
            if(!nodes[i].equals("#")){
                TreeNode leftChild = new TreeNode(Integer.parseInt(nodes[i]));
                parent.left = leftChild;
                q.add(leftChild);
            }
            if(!nodes[++i].equals("#")){
                TreeNode rightChild = new TreeNode(Integer.parseInt(nodes[i]));
                parent.right = rightChild;
                q.add(rightChild);
            }
        }
        return root;
    }

}
