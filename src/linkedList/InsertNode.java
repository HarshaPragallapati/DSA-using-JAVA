package linkedList;

import java.util.Arrays;
import java.util.List;

public class InsertNode {
    static void PrintLL(Node head)
    {
        while (head != null)
        {
            System.out.println(head.data + " ");
            head = head.next;
        }
    }
    static Node InsAtFirst(Node head, int val1){
        Node x = new Node(val1, head);
        return x;
    }
    static Node InsAtEnd(Node head, int val2){
        Node y = new Node(val2);
        if(head == null)
        {
            return y;
        }
        Node temp = head;
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
        Node head = new Node(arr.get(0));
        head.next = new Node(arr.get(1));
        head.next.next = new Node(arr.get(2));
        head.next.next.next = new Node(arr.get(3));
        head = InsAtFirst(head, 8);
        head = InsAtEnd(head, 30);
        PrintLL(head);
    }
}
