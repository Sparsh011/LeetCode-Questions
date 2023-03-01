package LinkedList;

public class LinkedListCycle2 {
//    In this question, we have to return the node where cycle was found.
    public SingleListNote detectCycle(SingleListNote head) {
        if(head == null || head.next == null) return null;
        SingleListNote slow = new SingleListNote(-1);
        SingleListNote temp = new SingleListNote(-1);
        slow.next = head;
        temp.next = head;
        SingleListNote fast = head;
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
