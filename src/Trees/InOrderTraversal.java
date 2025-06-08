package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}
public class InOrderTraversal {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        List<Integer> arr = new ArrayList<>();
        inOrder(root, arr);
        System.out.println(arr);
    }

    static void inOrder(TreeNode root, List<Integer> arr) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;
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
                arr.add(node.val);
                node = node.right;
            }
        }
    }
}
