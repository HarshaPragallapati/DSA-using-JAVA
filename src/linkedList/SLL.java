package linkedList;

class ListNode {
    int val;
    ListNode next;

    public ListNode(int data1)
    {
        this.val = data1;
    }

    public ListNode(int data1, ListNode next) {
        this.val = data1;
        this.next = next;
    }
}
class LL{
    ListNode convertArrayToLL(int[] arr){
        ListNode head = new ListNode(arr[0]);
        ListNode mover = head;
        for (int i = 1;i< arr.length;i++)
        {
            ListNode temp = new ListNode(arr[i]);
            mover.next = temp;
            mover = mover.next;
        }
        return head;
    }
    void printLL(ListNode head)
    {
        ListNode temp = head;
        while (temp != null)
        {
            System.out.print(temp.val + "\n");
            temp = temp.next;
        }
    }
}
public class SLL {

    public static void main(String args[])
    {
        int[] arr = {122,5,3,7};
        LL obj = new LL();
        ListNode head = obj.convertArrayToLL(arr);
        System.out.print(head.val);
        System.out.print("\nElements in the list are :\n");
        obj.printLL(head);
    }
}
