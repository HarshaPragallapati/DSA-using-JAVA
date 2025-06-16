package linkedList;

import java.util.Arrays;
import java.util.List;

public class DeleteNode {
    static void PrintLL(Node head)
    {
        while (head != null)
        {
            System.out.println(head.data + " ");
            head = head.next;
        }
    }
    static void RemoveNode(Node head, int val)
    {
        Node temp = head;
        while (temp.next.data != val)
        {
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(4, 5, 1, 9);
        Node head = new Node(arr.get(0));
        head.next = new Node(arr.get(1));
        head.next.next = new Node(arr.get(2));
        head.next.next.next = new Node(arr.get(3));
        RemoveNode(head, 1);
        PrintLL(head);
    }
}
