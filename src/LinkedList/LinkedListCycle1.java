package LinkedList;

public class LinkedListCycle1 {
    public boolean hasCycle(ListNode head) {
        ListNode slow = new ListNode(-1);
        slow.next = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }

        return false;
    }
}
