package LinkedList;

public class RemoveNthElementFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || (head.next == null)) return null;
        int position = n;
        ListNode fast = head, slow = head;

        while(position-- > 0 && fast != null){
            fast = fast.next;
        }

        if(fast == null) return head.next;

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return head;
    }
}
