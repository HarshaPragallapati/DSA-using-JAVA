package heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergekSortedLists {
    public static void main(String[] args) {
        // Example 1 input: [[1,4,5],[1,3,4],[2,6]]
        ListNode[] lists = new ListNode[3];
        lists[0] = createLinkedList(new int[]{1,4,5});
        lists[1] = createLinkedList(new int[]{1,3,4});
        lists[2] = createLinkedList(new int[]{2,6});

        System.out.println(mergeKLists(lists));
    }

    private static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode node : lists){
            if (node != null){
                pq.add(node);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (!pq.isEmpty()){
            ListNode temp = pq.poll();
            curr.next = temp;
            curr = curr.next;
            if (temp.next != null){
                pq.add(temp.next);
            }
        }
        return dummy.next;
    }

    public static ListNode createLinkedList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int num : arr) {
            curr.next = new ListNode(num);
            curr = curr.next;
        }
        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}
