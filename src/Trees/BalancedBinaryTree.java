package Trees;

public class BalancedBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.left.right.right.right = new Node(7);

        System.out.println(isBalanced(root) ? true : false);
    }

    private static boolean isBalanced(Node root) {
        return calculateHeight(root) != -1;
    }

    private static int calculateHeight(Node root) {
        if (root == null) return 0;
        int leftH = calculateHeight(root.left);
        if (leftH == -1){
            return -1;
        }
        int rightH = calculateHeight(root.right);
        if (rightH == -1){
            return -1;
        }

        if (Math.abs(leftH - rightH) > 1){
            return -1;
        }

        return Math.max(leftH, rightH) + 1;
    }
}
