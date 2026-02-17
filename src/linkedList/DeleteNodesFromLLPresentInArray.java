package linkedList;

public class DeleteNodesFromLLPresentInArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(3);
        ListNode newHead = modifiedList(nums, head);
        while (newHead != null){
            System.out.print(newHead.val + "->");
            newHead = newHead.next;
        }
    }

    private static ListNode modifiedList(int[] nums, ListNode head) {
        int maxi = -1;
        for (int num : nums){
            maxi = Math.max(num, maxi);
        }
        boolean[] freq = new boolean[maxi + 1];
        for (int num : nums){
            freq[num] = true;
        }
        ListNode temp = new ListNode();
        ListNode curr = temp;
        while (head != null){
            if (head.val >= freq.length || !freq[head.val]){
                curr.next = head;
                curr = curr.next;
            }
            head = head.next;
        }
        curr.next = null;
        return temp.next;
    }
}
