package linkedList;

import java.util.HashMap;
import java.util.Map;

public class RemoveNodesFromLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(2);
        head.next.next = new ListNode(13);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(8);
        ListNode newH = removeNodes(head);
        while (newH != null){
            System.out.print(newH.val + "->");
            newH = newH.next;
        }
    }

    private static ListNode removeNodes(ListNode head) {
        ListNode newH =reverse(head);
        int max = newH.val;
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while (newH != null){
            if (newH.val >= max){
                curr.next = newH;
                curr = curr.next;
                max = newH.val;
            }
            newH = newH.next;
        }
        return reverse(dummy.next);
    }

    private static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
