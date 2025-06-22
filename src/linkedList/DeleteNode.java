package linkedList;

import java.util.Arrays;
import java.util.List;

public class DeleteNode {
    static void PrintLL(ListNode head)
    {
        while (head != null)
        {
            System.out.println(head.val + " ");
            head = head.next;
        }
    }
    static void RemoveNode(ListNode head, int val)
    {
        ListNode temp = head;
        while (temp.next.val != val)
        {
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(4, 5, 1, 9);
        ListNode head = new ListNode(arr.get(0));
        head.next = new ListNode(arr.get(1));
        head.next.next = new ListNode(arr.get(2));
        head.next.next.next = new ListNode(arr.get(3));
        RemoveNode(head, 1);
        PrintLL(head);
    }
}
