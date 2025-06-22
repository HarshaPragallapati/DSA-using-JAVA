package linkedList;
public class OddEvenLL {
    public static void main(String[] args) {
        LL obj = new LL();
        ListNode head = obj.convertArrayToLL(new int[]{1,2,3,4,5});

        ListNode odd = head;
        ListNode even = head.next;
        while(odd.next != null && even.next != null)
        {
            odd.next = odd.next.next;
            even.next = even.next.next;
        }
        odd.next = head.next;
        obj.printLL(head);
    }
}
