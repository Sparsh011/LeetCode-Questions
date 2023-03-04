package LinkedList;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        ListNode temp = head;

        while (temp != null) {
            ListNode next = temp.next;
            temp.next = newHead;
            newHead = temp;
            temp = next;
        }

        return newHead;
    }
}
