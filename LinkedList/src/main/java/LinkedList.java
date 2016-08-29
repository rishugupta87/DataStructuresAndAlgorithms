import util.Node;

/**
 * Class that handles all the LinkedList operations
 */
public class LinkedList {

    private Node head;

    public Node getHead() {
        return head;
    }

    public LinkedList(final int data) {
        head = new Node(data);
    }



    public void appendAtHead(final int data) {
        if (head == null) {
            return;
        }
        final Node newNodeToAppend = new Node(data);
        newNodeToAppend.setNext(head);
        head = newNodeToAppend;
    }

    public void appendAtTail(final int data) {
        if (head == null) {
            return;
        }
        final Node newNodeToAppend = new Node(data);
        Node current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(newNodeToAppend);
    }

    public void appendAtPosition(final int data, final int position) {
        if (head == null) {
            return;
        }
        if (position == 1) {
            appendAtHead(data);
            return;
        }
        Node nodeToAppend = new Node(data);
        int count = 1;
        Node current = head;
        while (count != position - 1) {
            count++;
            current = current.getNext();
        }
        Node temp = current.getNext();
        current.setNext(nodeToAppend);
        nodeToAppend.setNext(temp);
    }

    public void deleteNodeAtPosition(final int data) {
        // Case 1: delete the node at position 1 (i.e the head of the linkedList)
        if (head.getData() == data) {
            head = head.getNext();
        } else {
            // iterate through the list
            Node previous = head;
            Node current = head.getNext();
            while (current.getData() != data) {
                current = current.getNext();
                previous = previous.getNext();
            }
            previous.setNext(current.getNext());
        }
    }

    public static Node reverseLinkedList_Iterative(Node head) {
        if(head == null) {
            return head;
        }

        //if only 1 element return the linked list.
        if(head.getNext() == null) {
            return head;
        }

        Node current = head;
        Node result = null;
        Node next;

        while(current != null) {
            next = current.getNext();
            current.setNext(result);
            result = current;
            current = next;
        }
        head = result;
        return head;
    }

    public static Node reverseLinkedList_Recursive(Node current) {
        if(current.getNext() == null) {
            return current;
        }
        Node head = reverseLinkedList_Recursive(current.getNext());
        current.getNext().setNext(current);
        current.setNext(null);
        return head;
    }
}
