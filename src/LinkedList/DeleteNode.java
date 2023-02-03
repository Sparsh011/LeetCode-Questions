package LinkedList;

public class DeleteNode {
//    Head node is not given in this, so we cannot traverse the list.
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
