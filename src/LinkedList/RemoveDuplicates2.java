package LinkedList;

public class RemoveDuplicates2 {
//    Remove duplicate items from sorted list, and also remove the element whose duplicate is present. Eg. 1 -> 2 -> 2 -> 3, for this case, the resultant list should be 1 -> 3 -> null.

    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head, prev = new ListNode(-1);
        prev.next = head;

        while(temp != null && temp.next != null){
            boolean flag = false;
            while(temp.next != null && temp.val == temp.next.val){
                temp = temp.next;
                flag = true;
            }
            if(flag) {
                if(prev.next == head){
                    head = temp.next;
                }
                prev.next = temp.next;
            }
            else {
                prev = prev.next;
            }
            temp = temp.next;
        }

        return head;
    }
}
