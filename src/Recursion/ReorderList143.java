package Recursion;

public class ReorderList143 {
    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        head.next = new ListNode(7);
        head.next.next = new ListNode(45);
        head.next.next.next = new ListNode(17);
        head.next.next.next.next = new ListNode(18);
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prev = null, curr = slow.next;
        slow.next = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        ListNode first = head, second = prev;
        while (second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }
        printList(head);
    }

    private static void printList(ListNode head) {
        while (head.next != null){
            System.out.print(head.data + "->");
            head = head.next;
        }
        System.out.println(head.data);
    }
}
