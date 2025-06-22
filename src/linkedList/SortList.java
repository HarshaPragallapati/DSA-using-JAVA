package linkedList;

public class SortList {
    public static void main(String[] args) {
        LL obj = new LL();
        ListNode head = obj.convertArrayToLL(new int[]{4,2,1,3});
        ListNode newHead = sortList(head);
        while (newHead != null){
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
    }

    private static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode mid = findMiddle(head);
        ListNode right = mid.next;
        mid.next = null;
        ListNode leftHead = sortList(head);
        ListNode rightHead = sortList(right);
        return mergeTwoSortedLists(leftHead, rightHead);
    }

    private static ListNode mergeTwoSortedLists(ListNode leftHead, ListNode rightHead) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while (leftHead != null && rightHead != null){
            if (leftHead.val > rightHead.val){
                temp.next = rightHead;
                rightHead = rightHead.next;
            }
            else {
                temp.next = leftHead;
                leftHead = leftHead.next;
            }
            temp = temp.next;
        }
        if (leftHead != null){
            temp.next = leftHead;
        }
        else{
            temp.next = rightHead;
        }
        return dummy.next;
    }

    private static ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
