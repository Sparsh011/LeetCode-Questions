package LinkedList;

public class DeleteMiddleNode {
    public static void main(String[] args) {

    }

    private static ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode slow = head, fast = head, temp = new ListNode(-1);
        temp.next = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            temp = temp.next;
        }

        temp.next = slow.next;
        return head;
    }
}
