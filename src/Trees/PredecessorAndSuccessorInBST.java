package Trees;

import java.util.ArrayList;
import java.util.Scanner;

public class PredecessorAndSuccessorInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(1);
        root.right = new TreeNode(9);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.right.right = new TreeNode(10);
        Scanner sc = new Scanner(System.in);
        int key = sc.nextInt();
        ArrayList<TreeNode> res = findPreSuc(root, key);
        int predecessor = res.getFirst() != null ? res.getFirst().val : -1;
        int successor = res.getLast() != null ? res.getLast().val : -1;
        System.out.println("Predecessor: " + predecessor);
        System.out.println("Successor: " + successor);
        sc.close();
    }

    private static ArrayList<TreeNode> findPreSuc(TreeNode root, int key) {
        TreeNode pre = null, succ = null, curr = null;
        ArrayList<TreeNode> list = new ArrayList<>();
        while (root != null){
            if (root.val < key){
                pre = root;
                root = root.right;
            } else if (root.val > key) {
                succ = root;
                root = root.left;
            }else {
                if (root.left != null){
                    pre = root.left;
                    while (pre.right != null){
                        pre = pre.right;
                    }
                }
                if (root.right != null){
                    succ = root.right;
                    while (succ.left != null){
                        succ = succ.left;
                    }
                }
                break;
            }
        }
        list.add(pre);
        list.add(succ);
        return list;
    }
}
