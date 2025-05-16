package Trees;

public class SymmetricTree {
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right .right = new Node(7);
        System.out.println(isSymmetric(root.left, root.right));
    }

    private static boolean isSymmetric(Node root1, Node root2){
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        return (root1.data == root2.data && isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left));
    }
}
