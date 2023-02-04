package LinkedList;

public class RotateList {
//    Unoptimised code - add elements to a list like this :
//    while(newK-- > 0){
//        list.add(0, list.get(list.size() - 1));
//        list.remove(list.size() - 1);
//    }
//    Here newK = k % size.
//    After adding elements to the list, the list will represent the rotated list and then create a new LinkedList and add elements to that new list.


//    Cut the nodes that will come to the front after rotation and attach them to the beginning of the list. TC - O(N) and SC - O(1).

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode res = new ListNode(-1);
        int size = 1;
        ListNode fast = head;

        while(fast.next != null){
            size++;
            fast = fast.next;
        }
        int newK = k % size;
        if(newK == 0) return head;

        ListNode temp = head;

        for(int i = size - newK - 1; i > 0; i--){
            temp = temp.next;
        }

        res.next = temp.next;
        temp.next = null;
        fast.next = head;

        return res.next;
    }
}
