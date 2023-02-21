package LinkedList;

public class LinkedListCycle2 {
//    In this question, we have to return the node where cycle was found.
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode slow = new ListNode(-1);
        ListNode temp = new ListNode(-1);
        slow.next = head;
        temp.next = head;
        ListNode fast = head;
        boolean found = false;

        while(fast != null && fast.next != null){
            if(fast == slow) {
                found = true;
                fast = fast.next;
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        while(found && temp != fast){
            temp = temp.next;
            fast = fast.next;
        }

        return found ? temp : null;
    }
}
