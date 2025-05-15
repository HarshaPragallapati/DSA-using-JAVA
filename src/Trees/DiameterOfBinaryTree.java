package Trees;

public class DiameterOfBinaryTree {
    private static int diameter = 0;
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        findDiameter(root);
        System.out.println(diameter);
    }

    private static int findDiameter(Node root) {
        if (root == null) return 0;
        int leftH = findDiameter(root.left);
        int rightH = findDiameter(root.right);
        diameter = Math.max(diameter, leftH + rightH);
        return Math.max(leftH, rightH) + 1;
    }
}
