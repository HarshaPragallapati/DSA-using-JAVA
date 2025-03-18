package Linked_list;
public class OddEvenLL {
    public static void main(String[] args) {
        LL obj = new LL();
        Node head = obj.convertArrayToLL(new int[]{1,2,3,4,5});

        Node odd = head;
        Node even = head.next;
        while(odd.next != null && even.next != null)
        {
            odd.next = odd.next.next;
            even.next = even.next.next;
        }
        odd.next = head.next;
        obj.printLL(head);
    }
}
