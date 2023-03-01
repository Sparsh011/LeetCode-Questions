package LinkedList;

public class RemoveDuplicates {
//    Remove duplicates from sorted list. Don't remove the element that is repeated.

    private SingleListNote deleteDuplicates(SingleListNote head) {
        if(head == null || head.next == null) return head;
        SingleListNote temp = head;

        while(temp.next != null){
            if(temp.val == temp.next.val){
                temp.next = temp.next.next;
            }
            else{
                temp = temp.next;
            }
        }

        return head;
    }
}
