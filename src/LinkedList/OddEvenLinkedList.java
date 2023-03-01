package LinkedList;

public class OddEvenLinkedList {
    public SingleListNote oddEvenList(SingleListNote head) {
        if(head == null || head.next == null) return head;
        SingleListNote oddTail = head, evenTail = head.next;
        SingleListNote oddHead = head, evenHead = head.next;

        // Making odd store the reference of even node and so on :

        while(oddTail.next != null && evenTail.next != null){
            oddTail.next = evenTail.next;
            oddTail = oddTail.next;
            evenTail.next = oddTail.next;
            evenTail = evenTail.next;
        }

        // Have formed 2 separate lists, one for odd and other for even, now connecting odd's end with even.
        oddTail.next = evenHead;
        return oddHead;
    }
}
