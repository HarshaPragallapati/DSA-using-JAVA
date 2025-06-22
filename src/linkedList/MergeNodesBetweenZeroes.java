package linkedList;

public class MergeNodesBetweenZeroes {
    public static void main(String[] args) {
        LL obj = new LL();
        ListNode head = obj.convertArrayToLL(new int[]{0,3,1,0,4,5,2,0});
        ListNode newHead = mergeNodes(head);
        while (newHead != null){
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
    }

    private static ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        ListNode curr = head.next;
        int sum = 0;
        while(curr != null){
            if(curr.val == 0){
                temp.next = new ListNode(sum);
                temp = temp.next;
                sum = 0;
            }else{
                sum += curr.val;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
