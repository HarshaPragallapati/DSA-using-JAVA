package linkedList;

public class RemoveDuplicatesFromSortedList2 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
        ListNode newH = deleteDuplicates(head);
        while (newH != null){
            System.out.print(newH.val + " ");
            newH = newH.next;
        }
    }

    private static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        ListNode curr = head;
        while (curr != null){
            if (curr.next != null && curr.val == curr.next.val){
                while (curr.next != null && curr.val == curr.next.val){
                    curr = curr.next;
                }
                prev.next = curr.next;
            }
            else {
                prev = prev.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
