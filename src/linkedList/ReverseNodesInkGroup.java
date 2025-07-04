package linkedList;

public class ReverseNodesInkGroup {
    public static void main(String[] args) {
        LL obj = new LL();
        ListNode head = obj.convertArrayToLL(new int[]{1,2,3,4,5});
        int k = 2;
        ListNode newHead = reverseKGroup(head, k);
        while (newHead != null){
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
    }

    private static ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevLast = null;
        while (temp != null){
            ListNode kThNode = getKthNode(temp, k);
            if (kThNode == null){
                if (prevLast != null){
                    prevLast.next = temp;
                }
                break;
            }
            ListNode nextNode = kThNode.next;
            kThNode.next = null;
            reverseList(temp);
            if (temp == head){
                head = kThNode;
            }
            else {
                prevLast.next = kThNode;
            }
            prevLast = temp;
            temp = nextNode;
        }
        return head;
    }

    private static ListNode getKthNode(ListNode temp, int k) {
        k -= 1;
        while (temp != null && k > 0){
            k--;
            temp = temp.next;
        }
        return temp;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode temp = head;
        ListNode before = null;
        ListNode after = null;
        while(temp != null)
        {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
        return before;
    }
}
