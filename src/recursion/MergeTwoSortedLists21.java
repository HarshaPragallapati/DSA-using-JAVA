package recursion;
class ListNode{
    int data;
    ListNode next;

    public ListNode(int data1)
    {
        this.data = data1;
        this.next = null;
    }

    public ListNode(int data1, ListNode next) {
        this.data = data1;
        this.next = next;
    }
}
public class MergeTwoSortedLists21 {
    static ListNode merge(ListNode l1, ListNode l2){
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.data < l2.data){
            l1.next = merge(l1.next, l2);
            return l1;
        }
        else{
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(10);
        ListNode list2 = new ListNode(3);
        list2.next = new ListNode(5);
        list2.next.next = new ListNode(7);
        ListNode mergedHead = merge(list1, list2);
        printList(mergedHead);
    }

    private static void printList(ListNode head) {
        while (head.next != null){
            System.out.print(head.data + "->");
            head = head.next;
        }
        System.out.println(head.data);
    }
}
