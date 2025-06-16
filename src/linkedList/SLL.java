package linkedList;

class Node{
    int data;
    Node next;

    public Node(int data1)
    {
        this.data = data1;
    }

    public Node(int data1, Node next) {
        this.data = data1;
        this.next = next;
    }
}
class LL{
    Node convertArrayToLL(int[] arr){
        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i = 1;i< arr.length;i++)
        {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = mover.next;
        }
        return head;
    }
    void printLL(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data + "\n");
            temp = temp.next;
        }
    }
}
public class SLL {

    public static void main(String args[])
    {
        int[] arr = {122,5,3,7};
        LL obj = new LL();
        Node head = obj.convertArrayToLL(arr);
        System.out.print(head.data);
        System.out.print("\nElements in the list are :\n");
        obj.printLL(head);
    }
}
