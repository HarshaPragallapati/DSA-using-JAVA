package Trees;

public class MaximumPathSum {
    private static int max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Node root = new Node(-10);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        findMaxPath(root);
        System.out.println(max);
    }

    private static int findMaxPath(Node root) {
        if (root == null) return 0;
        int leftH = Math.max(0, findMaxPath(root.left));
        int rightH = Math.max(0,findMaxPath(root.right));
        max = Math.max(max, leftH + rightH + root.data);
        return root.data + Math.max(leftH, rightH);
    }
}
