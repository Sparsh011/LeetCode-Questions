package LinkedList;

public class DeleteMiddleNode {
    public static void main(String[] args) {

    }

    private static SingleListNote deleteMiddle(SingleListNote head) {
        if(head == null || head.next == null) return null;
        SingleListNote slow = head, fast = head, temp = new SingleListNote(-1);
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
