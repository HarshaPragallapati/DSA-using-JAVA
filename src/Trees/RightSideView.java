package Trees;

import java.util.ArrayList;
import java.util.List;

public class RightSideView {
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right .right = new Node(7);
        List<Integer> result = new ArrayList<>();
        dfs(root, 0 , result);
        System.out.println(result);
    }

    private static void dfs(Node root, int i, List<Integer> result) {
        if (root == null) return;
        if (i == result.size()) result.add(root.data);
        dfs(root.right, i + 1, result);
        dfs(root.left, i + 1, result);
    }

}
