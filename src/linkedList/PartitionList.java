package linkedList;

public class PartitionList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        int x = 3;
        ListNode newH = partition(head, x);
        while (newH != null){
            System.out.print(newH.val + " ");
            newH = newH.next;
        }
    }

    private static ListNode partition(ListNode head, int x) {
        ListNode smallDummy = new ListNode(0);
        ListNode small = smallDummy;
        ListNode largeDummy = new ListNode(0);
        ListNode large = largeDummy;
        while (head != null){
            if (head.val >= x){
                large.next = head;
                large = large.next;
            }
            else {
                small.next = head;
                small = small.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeDummy.next;
        return smallDummy.next;
    }
}
