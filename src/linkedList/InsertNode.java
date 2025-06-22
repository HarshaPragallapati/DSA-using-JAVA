package linkedList;

import java.util.Arrays;
import java.util.List;

public class InsertNode {
    static void PrintLL(ListNode head)
    {
        while (head != null)
        {
            System.out.println(head.val + " ");
            head = head.next;
        }
    }
    static ListNode InsAtFirst(ListNode head, int val1){
        ListNode x = new ListNode(val1, head);
        return x;
    }
    static ListNode InsAtEnd(ListNode head, int val2){
        ListNode y = new ListNode(val2);
        if(head == null)
        {
            return y;
        }
        ListNode temp = head;
        while(temp.next != null)
        {
            temp = temp.next;
        }
        temp.next = y;
        return head;
    }
    public static void main(String[] args)
    {
        List<Integer> arr = Arrays.asList(12, 6, 5, 8);
        ListNode head = new ListNode(arr.get(0));
        head.next = new ListNode(arr.get(1));
        head.next.next = new ListNode(arr.get(2));
        head.next.next.next = new ListNode(arr.get(3));
        head = InsAtFirst(head, 8);
        head = InsAtEnd(head, 30);
        PrintLL(head);
    }
}
