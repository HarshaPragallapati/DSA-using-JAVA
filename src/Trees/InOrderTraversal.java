package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Node{
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}
public class InOrderTraversal {


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        List<Integer> arr = new ArrayList<>();
        inOrder(root, arr);
        System.out.println(arr);
    }

    private static void inOrder(Node root, List<Integer> arr) {
        Stack<Node> st = new Stack<>();
        Node node = root;
        while (true){
            if(node != null){
                st.push(node);
                node = node.left;
            }
            else {
                if (st.isEmpty()){
                    break;
                }
                node = st.pop();
                arr.add(node.data);
                node = node.right;
            }
        }
    }
}
