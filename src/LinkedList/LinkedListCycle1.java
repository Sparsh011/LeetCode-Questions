package LinkedList;

public class LinkedListCycle1 {
    public boolean hasCycle(SingleListNote head) {
        SingleListNote slow = new SingleListNote(-1);
        slow.next = head;
        SingleListNote fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }

        return false;
    }
}
