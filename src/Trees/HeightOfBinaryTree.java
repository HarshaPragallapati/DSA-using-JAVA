package Trees;

public class HeightOfBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        System.out.println(findHeight(root));
    }

    private static int findHeight(Node root) {
        if (root == null) return 0;
        int leftH = findHeight(root.left);
        int rightH = findHeight(root.right);
        return 1 + Math.max(leftH, rightH);
    }
}
