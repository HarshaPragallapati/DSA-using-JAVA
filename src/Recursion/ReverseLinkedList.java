package Recursion;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(10);
        ListNode newHead = reverseList(head);
        printList(newHead);
    }

    private static void printList(ListNode head) {
        while (head.next != null){
            System.out.print(head.data + "->");
            head = head.next;
        }
        System.out.println(head.data);
    }

    private static ListNode reverseList(ListNode list1) {
        if (list1 == null || list1.next == null){
            return list1;
        }
        ListNode newH = reverseList(list1.next);
        list1.next.next = list1;
        list1.next = null;
        return newH;
    }
}
