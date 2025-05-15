package Trees;

import java.util.*;

public class PreOrder {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        List<Integer> arr = new ArrayList<>();
        preOrder(root, arr);
        System.out.println(arr);
    }

    private static void preOrder(Node root, List<Integer> arr) {
        Stack<Node> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            root = st.pop();
            arr.add(root.data);
            if(root.right != null){
                st.push(root.right);
            }
            if(root.left != null){
                st.push(root.left);
            }
        }
    }
}
