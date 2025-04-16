package Recursion;

import com.sun.source.tree.Tree;

public class SwapNodesInPairs {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode l1 = head;
        ListNode l2 = head.next;
        ListNode newHead = swapPairs(head);
        printList(newHead);
    }
    private static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode firstNode = head;
        ListNode secondNode = head.next;
        firstNode.next = swapPairs(secondNode.next);
        secondNode.next = firstNode;
        return secondNode;
    }


    private static void printList(ListNode head) {
        while (head.next != null){
            System.out.print(head.data + "->");
            head = head.next;
        }
        System.out.println(head.data);
    }
}
