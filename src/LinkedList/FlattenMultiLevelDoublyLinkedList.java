package LinkedList;

import java.util.Stack;

public class FlattenMultiLevelDoublyLinkedList {
    public DoublyLinkedNode flatten(DoublyLinkedNode head) {
        DoublyLinkedNode temp = head;
        Stack<DoublyLinkedNode> stack = new Stack<>();

        while(temp != null) {
            if(temp.child != null) {
                DoublyLinkedNode next = temp.next;
                if(next != null) stack.add(next); // If null is added here, it will be attached to the list in else if block

                // Changing the references of temp and it's child:
                temp.next = temp.child;
                temp.next.prev = temp;
                temp.child = null;
            }
            else if(temp.next == null && !stack.isEmpty()) {
                temp.next = stack.pop(); // Stack will never have null in it.
                temp.next.prev = temp;
            }

            temp = temp.next;
        }

        return head;
    }
}
