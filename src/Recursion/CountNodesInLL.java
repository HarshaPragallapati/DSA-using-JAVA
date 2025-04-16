package Recursion;

public class CountNodesInLL {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(10);
        head.next.next.next = new ListNode(18);
        int count = CountNodes(head);
        System.out.println(count);
    }

    private static int CountNodes(ListNode head) {
        if (head == null){
            return 0;
        }
        return 1 + CountNodes(head.next);
    }
}
